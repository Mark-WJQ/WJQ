package com.wjq.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class H2O {


    private static Random random = new Random(47);


    List<Hydrogen> list = new ArrayList<>();

    private ExecutorService service = Executors.newCachedThreadPool();


    public H2O() {

        barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 3; j++) {
                    //service.execute(list.get(j));
                }
            }
        });

        Hydrogen h1 = new Hydrogen(barrier, "H");
        list.add(h1);
        service.execute(h1);
        Hydrogen h2 = new Hydrogen(barrier, "H");
        list.add(h2);
        service.execute(h2);
        Hydrogen h3 = new Hydrogen(barrier, "O");
        list.add(h3);
        service.execute(h3);


    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
    }


    CyclicBarrier barrier;


    public static void main(String[] args) {
        new H2O();
    }


    class Hydrogen implements Runnable {

        private CyclicBarrier barrier;

        private String str;

        public Hydrogen(CyclicBarrier barrier, String str) {
            this.barrier = barrier;
            this.str = str;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.print(str);

                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
