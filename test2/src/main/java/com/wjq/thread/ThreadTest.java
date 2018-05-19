package com.wjq.thread;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/6.
 */
public class ThreadTest implements Runnable{


   static int i = 0;


    /**
     * 一个实例中多个 synchronized 修饰的方法在同一时刻只能有一个线程访问一个方法，所以会互斥
     * @throws InterruptedException
     */
    synchronized void inc() throws InterruptedException {
        i++;
        i++;
        //TimeUnit.SECONDS.sleep(10);
       // System.out.println("++" + i);
    } ;
    synchronized int getI(){
       return i;
   }


    @Override
    public void run() {
        while (true)
            try {
                inc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {

       ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {

                Thread t = new Thread(r);

                //设置捕捉线程抛出的的异常
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("catch thread exception " + e.getCause());
                    }
                });

                return t;
            }
        });

      //  ExecutorService service = Executors.newCachedThreadPool();

        ThreadTest runnable = new ThreadTest();
        service.execute(runnable);

        int k = 0;
        while (true){
            if ( (k = runnable.getI())% 2 != 0){
                System.out.println(k);
                break;
            }
        }
        service.shutdown();
        System.exit(1);
        CyclicBarrier barrier = new CyclicBarrier(10);
        CountDownLatch countDownLatch;


        new Timer();


    }
}
