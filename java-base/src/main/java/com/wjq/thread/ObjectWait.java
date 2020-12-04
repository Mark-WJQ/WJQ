package com.wjq.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjianqiang on 2018/5/12.
 */
public class ObjectWait {


    static class T1 implements Runnable{


        ThreadTest threadTest = new ThreadTest();

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

            System.out.println("start wait");
           testWait();
            System.out.println("hahahhahah");
        }





        public synchronized void testWait(){
           /* try {
                synchronized(threadTest) {
                    threadTest.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


                System.out.println("sleep");
                //Thread.sleep(10000);
                System.out.println("sleep end");




        }

        public synchronized void testnotify() throws InterruptedException {

           /* synchronized (threadTest) {
                threadTest.notify();
            }
                TimeUnit.SECONDS.sleep(2);
            System.out.println("notify");*/

            System.out.println("other thread");


        }

    }


   static class T2 implements Runnable{

        private T1 t1;

        public T2(T1 t1) {
            this.t1 = t1;
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
                System.out.println("start sleep");
                //TimeUnit.SECONDS.sleep(5);
                t1.testnotify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
       T1 t1 = new T1();
        pool.execute(t1);
        TimeUnit.SECONDS.sleep(1);
        pool.execute(new T2(t1));

        pool.shutdown();

    }







}
