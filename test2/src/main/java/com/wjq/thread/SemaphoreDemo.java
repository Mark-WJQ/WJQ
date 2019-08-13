package com.wjq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianqiang on 2018/5/17.
 */
public class SemaphoreDemo {

    final static int SIZE = 5;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class,SIZE);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < SIZE; i++){
            exec.execute(new CheckOutTask<Fat>(pool));
        }

        System.out.println("All CheckoutTask created");

        List<Fat> list = new ArrayList<>();
        for (int i = 0 ; i < SIZE; i++){
            Fat fat = pool.checkOut();
            System.out.println(i + ": main thread checkout");
            fat.operation();;
            list.add(fat);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                    System.out.println("always check");
                } catch (InterruptedException e) {
                    System.out.println("checkout interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);

        blocked.cancel(true);
        System.out.println("Chcking in objects in " + list);

        for (Fat f : list){
            pool.checkIn(f);
        }

        for (Fat f : list){
            pool.checkIn(f);
        }

        exec.shutdownNow();


    }

}



class Pool<T>{
    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkout;

    private Semaphore available;


    public Pool(Class<T> clazz,int size) throws IllegalAccessException, InstantiationException {


        this.size = size;
        checkout = new boolean[size];
        available = new Semaphore(size,true);
        for (int i = 0 ; i < size; i++) {
            items.add(clazz.newInstance());
        }
    }


    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }



    public void checkIn(T item){
        available.release();
        releaseItem(item);
    }

    private synchronized T getItem(){
        for (int i = 0 ; i < size;i++){
            if (!checkout[i]){
                checkout[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item){

        int index = items.indexOf(item);
        if (index == -1) return false;
        if (checkout[index]){
            checkout[index] = false;
            return true;
        }
        return false;
    }


}


class Fat{
    private volatile double d;
    private static int counter = 0;
    private final  int id = counter ++;


    public Fat() {
        for (int i = 1 ; i < 10000; i++){
            d += (Math.PI + Math.E)/(double) i;
        }
    }


    public void operation(){
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Fat id: " + id;
    }
}


class CheckOutTask<T> implements Runnable{


    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;


    public CheckOutTask(Pool<T> pool) {
        this.pool = pool;
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
            T item = pool.checkOut();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + "checking in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "CheckoutTask " + id + " " ;
    }
}