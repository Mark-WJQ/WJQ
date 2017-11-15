package com;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2017/11/6.
 */
public class test {

    static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

   static CountDownLatch latch = new CountDownLatch(2);

    static void  test(){
         ListenableFuture future = service.submit(new Runnable() {
            public void run() {
                System.out.println("submit");
            }
        });

        future.cancel(true);

        future.addListener(new Runnable() {
            public void run() {

                System.out.println("addListener");
            }
        },service);


        Futures.addCallback(future, new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("success");
            }

            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        });
        System.out.println(Thread.currentThread().getId() +latch.getCount());
        latch.countDown();


    }

    static void  test1(){
        ListenableFuture future = service.submit(new Runnable() {
            public void run() {
                System.out.println("submit");

            }
        });



        future.addListener(new Runnable() {
            public void run() {

                System.out.println("addListener");
            }
        },service);



        Futures.addCallback(future, new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("success");
            }

            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        });
        System.out.println(Thread.currentThread().toString() + latch.getCount());
        latch.countDown();

    }


    static void  test2() throws ExecutionException, InterruptedException {
       /* ListenableFuture future = service.submit(new Runnable() {
            public void run() {
                System.out.println("submit");

            }
        });*/

        ListenableFuture future = service.submit(new Callable<Object>() {
            public Object call() throws Exception {
                return "test2";
            }
        });



        future.addListener(new Runnable() {
            public void run() {

                System.out.println("addListener");
            }
        },service);


        Futures.addCallback(future, new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("success");
            }

            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        });
        System.out.println(Thread.currentThread().toString() + latch.getCount());
        System.out.println(future.get());
        latch.countDown();

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test();
        test1();
        test2();
        latch.await();
        System.out.println("dddd");
        service.shutdown();
    }
}
