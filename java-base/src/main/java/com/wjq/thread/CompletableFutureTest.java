package com.wjq.thread;

import java.util.concurrent.*;

public class CompletableFutureTest {



    private static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureTest test = new CompletableFutureTest();
        CompletableFuture future = test.test().thenApply(o->o);

        System.out.println("---------------");
        //CompletableFuture<String> future = test.testNew().thenApply((o) -> (String)o);
        System.out.println(future.get());
        //System.out.println(future.get());
        service.shutdown();

    }



    public CompletableFuture testNew(){




        CompletableFuture future = new CompletableFuture();




        future.whenComplete((s,t)->{
            System.out.println(s);
        });


        try {
            System.out.println("main thread");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.complete("hahahh");
        return future;



    }




    public CompletableFuture test(){


        CompletableFuture future = CompletableFuture.runAsync(new R1(),service);

        future.whenComplete((e,t) ->{
            System.out.println("future complete");
            System.out.println(e);
            System.out.println(t);
        });




        //future.complete("dhhdhdh");

        System.out.println("main thread");
        return future;

    }




    public void testSupply(){
       CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
           try {
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return "testSupply";
        },service);





       future.whenComplete((s, throwable) -> {
           System.out.println(s);
       });


        System.out.println("testSupply main thread");



    }



    class R1 implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------");
        }
    }















}
