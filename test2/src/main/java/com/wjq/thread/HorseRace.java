package com.wjq.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/13.
 */
public class HorseRace {


    static final int FINISH_LINE = 75;

    private List<Horse> horses = new ArrayList<>();
    private ExecutorService service = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses,final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i=0;i< FINISH_LINE;i++)
                    s.append("=");
                System.out.println(s);
                for (Horse horse : horses)
                    System.out.println( horse.tracks());
                for (Horse horse : horses)
                    if (horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + " WON");
                        service.shutdownNow();
                        return;
                    }
                    try{
                        TimeUnit.MILLISECONDS.sleep(pause);
                    } catch (InterruptedException e) {
                        System.out.println("barrier-action slee[p interrupted");
                    }
            }
        });

        for (int i = 0; i < nHorses; i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            service.execute(horse);
        }
    }


    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 2000;
        new HorseRace(nHorse,pause);
    }
}


class Horse implements Runnable{

    private static int counter = 0;
    private final int id = counter++;

    private int strides = 0;

    private static Random random = new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public synchronized int getStrides() {
        return strides;
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

        try{
            while (!Thread.interrupted()){
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String toString() {
        return "Horse " + id + " ";
    }


    public String tracks(){
        StringBuilder s = new StringBuilder();
        for (int i = 0 ; i < getStrides(); i++)
            s.append("*");
        s.append(id);
        return s.toString();
    }
}
