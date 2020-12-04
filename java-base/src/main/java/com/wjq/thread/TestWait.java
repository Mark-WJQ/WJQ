package com.wjq.thread;

import java.util.concurrent.*;

public class TestWait {


    /**
     * 执行数据发送线程池
     */
    private static ExecutorService sendExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("-------------------" + Thread.currentThread().getId());
            r.run();
        }
    });

    public static void main(String[] args) {


        TestWait testWait = new TestWait();

        System.out.println("main thread " + Thread.currentThread().getId());

        sendExecutor.submit(() -> {
            try {
                System.out.println("thread " + Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("---------------");
                testWait.notify1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        sendExecutor.submit(() -> {
            System.out.println("++++++++++++" + Thread.currentThread().getId());
            testWait.notify1();

        });
        testWait.wait1();
        sendExecutor.shutdown();


    }


    public synchronized void notify1() {
        System.out.println("notify");
        notifyAll();
    }


    public synchronized void wait1() {
        System.out.println("wait");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
