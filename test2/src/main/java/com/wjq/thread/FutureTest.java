package com.wjq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/2/11.
 */
public class FutureTest {








    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        /*List<Callable<String>> list = new ArrayList<>();
        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "sssss";
            }
        });

        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
                return "kkk";
            }
        });
        List<Future<String>> futureList = service.invokeAll(list);*/


        List<Future<String>> futureList = new ArrayList<>();
        String a = "1";

        futureList.add( service.submit(new Task(),a));

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1111");
            }
        });


        for (Future future : futureList){

                System.out.println(future.get());

        }


        System.out.println("wwww");

        service.shutdown();

    }

    static class Task implements Runnable{

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
            System.out.println("task");
        }
    }








}


