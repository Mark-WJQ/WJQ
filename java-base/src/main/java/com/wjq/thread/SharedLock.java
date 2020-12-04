package com.wjq.thread;



import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 共享锁
 */
public class SharedLock {


    private ExecutorService service = Executors.newFixedThreadPool(5);


    private CountDownLatch latch = new CountDownLatch(1);


    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public static void main(String[] args) {
        SharedLock sharedLock = new SharedLock();
        //sharedLock.test();
        sharedLock.testReadWrite();

    }


    public void testReadWrite(){

        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();




        service.submit(new Write(writeLock));
        service.submit(new Read1(readLock,true));
        service.submit(new Read1(readLock,false));



        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.submit(new Read1(readLock,false));

        service.shutdown();

    }


    public void test() {







        R r1 = new R("1", latch);



        RAwaite r3 = new RAwaite(latch, "3");

        RAwaite r4 = new RAwaite(latch, "4");


        RAwaite r5 = new RAwaite(latch, "5");

        RAwaite r6 = new RAwaite(latch, "6");


        service.execute(r4);
        service.execute(r3);

        service.execute(r5);
        service.execute(r6);

        try {
            TimeUnit.SECONDS.sleep(5);
            service.execute(r1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();


    }


    class R implements Runnable {


        private String s;

        private CountDownLatch latch;


        public R(String s, CountDownLatch latch) {
            this.s = s;
            this.latch = latch;
        }

        @Override
        public void run() {

            System.out.println("---------------countDown : " + s + ":" + LocalDateTime.now());
            latch.countDown();
            System.out.println("---------------countDown after : " + s + ":" + LocalDateTime.now());

        }
    }


    class RAwaite implements Runnable {


        private CountDownLatch latch;

        private String s;

        public RAwaite(CountDownLatch latch, String s) {
            this.latch = latch;
            this.s = s;
        }


        @Override
        public void run() {
            try {
                System.out.println("awaite befor : " + s + LocalDateTime.now());
                latch.await();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("awaite after : " + s + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    static class Read1 implements Runnable{


        private Lock lock;

        private boolean sleep;

        public Read1(Lock lock,boolean sleep) {
            this.lock = lock;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            lock.lock();
            if (sleep) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("read locak" + Thread.currentThread());

            lock.unlock();

        }
    }




    static class Write implements Runnable{

        private Lock lock;

        public Write(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("write lock" + Thread.currentThread());
            lock.unlock();
        }
    }

}

