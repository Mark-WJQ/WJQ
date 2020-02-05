package com.wjq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName TestRunnable.java
 * @createTime 2019年12月18日 22:04:00
 */
public class TestRunnable {




    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        for (int i=0;i < 100000;i ++){

           service.submit( new Runnable(){

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
                    System.out.println("-----------------");
                }
            });

        }
    }


}
