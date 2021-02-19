package com.wjq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianqiang on 2018/5/13.
 */
public class WaxOmatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new WaxOff(car));
        service.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(5);

        service.shutdownNow();
    }

}


class Car{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean waxOn = false;


    public void waxed(){

        try{
            lock.lock();
            waxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void buffed(){
        try{
            lock.lock();
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public void waitForWaxing() throws InterruptedException{

        try{
            lock.lock();
            while (waxOn == false) {
                condition.await();


                System.out.println("wait waxing");
            }
        } finally {
            lock.unlock();
        }
    }


    public void waitForBuffering() throws InterruptedException{

        try{
            lock.lock();
            while (waxOn == true){
                System.out.println("before");
                condition.await();
                System.out.println("wait buff");
            }
        } finally {
            lock.unlock();
        }
    }


}


class WaxOn implements Runnable{


    private Car car;

    public WaxOn(Car car) {
        this.car = car;
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
        while (!Thread.interrupted()){
            System.out.println("wax on");
            try {
                TimeUnit.MICROSECONDS.sleep(200000);
                System.out.println("sleep");
                car.waxed();
                car.waitForBuffering();
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
                Thread.currentThread().interrupt();

            }
        }
        System.out.println("Endi ng Wax On task");
    }
}


class WaxOff implements Runnable{

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
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
        while (!Thread.interrupted()){

            try {
                car.waitForWaxing();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(2000);
                car.buffed();
            } catch (InterruptedException e) {
                System.out.println("Exitong via interrupt");
            }
        }
        System.out.println("Ending Wax Off task");
    }
}

