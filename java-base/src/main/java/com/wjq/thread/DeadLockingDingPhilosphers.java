package com.wjq.thread;


import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/13.
 */
public class DeadLockingDingPhilosphers {


    public static void main(String[] args) throws IOException {
        int ponder = 5;
        int size = 5;
        ExecutorService pool = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0 ; i < size;i++)
            chopsticks[i] = new Chopstick(i);

        for (int i = 0 ; i < size ; i++)
            pool.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%size],i,ponder));
        System.out.println("Press Enter to quiet");
        System.in.read();
        pool.shutdownNow();
    }


}


class FixDeadLockingDingPhilosphers{
    public static void main(String[] args) throws IOException {
        int ponder = 5;
        int size = 5;
        ExecutorService pool = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0 ; i < size;i++)
            chopsticks[i] = new Chopstick(i);
        for (int i = 0 ; i < size ; i++) {
        if (i < size -1)
            pool.execute(new Philosopher(chopsticks[i], chopsticks[i+1], i, ponder));
        else
            pool.execute(new Philosopher(chopsticks[0],chopsticks[i],i,ponder));
        }
        System.out.println("Press Enter to quiet");
        System.in.read();
        pool.shutdownNow();

    }
}



class Chopstick{


    private boolean taken = false;
    private int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }


    public synchronized void drop(){
        taken = false;
        notifyAll();
    }

    public int getId() {
        return id;
    }
}



class Philosopher implements Runnable{

    private Chopstick left;

    private Chopstick right;

    private final int id;


    private final int ponderFactor;

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    private Random rand = new Random(47);


    private void pause() throws InterruptedException {
        if (ponderFactor == 0)
            return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
    }



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();

                right.take();
                System.out.println(this + " grabbing right" + right.getId());
                left.take();
                System.out.println(this + " grabbing left" + left.getId());
                System.out.println(this + " eating");
                pause();
                System.out.println(this + " drop " + right.getId());
                right.drop();
                System.out.println(this + " drop " + left.getId());
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "philosoper " + id;
    }
}


class ChopstickQueue extends LinkedBlockingQueue<Chopstick>{}

class Philosopher1 implements Runnable{

    private Chopstick left;

    private Chopstick right;

   private ChopstickQueue queue;

    private final int id;

    private final int ponderFactor;

    public Philosopher1(ChopstickQueue queue, int id, int ponderFactor) throws InterruptedException {
        this.queue = queue;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    private Random rand = new Random(47);


    private void pause() throws InterruptedException {
        if (ponderFactor == 0)
            return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
    }



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                right = queue.take();
                left = queue.take();
                System.out.println(this + " eating");
                pause();
                queue.put(right);
                queue.put(left);
                System.out.println(this + " drop");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "philosoper " + id;
    }
}


class KinDeadLockingDingPhilosphers{
    public static void main(String[] args) throws IOException, InterruptedException {
        int ponder = 10;
        int size = 2;
        ExecutorService pool = Executors.newCachedThreadPool();
        ChopstickQueue queue = new ChopstickQueue();
        for (int i = 0 ; i < size;i++)
            queue.add(new Chopstick(i));
        for (int i = 0 ; i < size ; i++) {
                pool.execute(new Philosopher1(queue, i, ponder));

        }
        System.out.println("Press Enter to quiet");
        System.in.read();
        pool.shutdownNow();


        CyclicBarrier barrier = new CyclicBarrier(1,null);

    }
}