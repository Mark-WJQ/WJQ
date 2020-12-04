package com.wjq.thread;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 排它锁
 * <p>
 * test Exclusive mode in AQS,test Condition
 */
public class ExcluLock {


    public static void main(String[] args) {

        ExcluLock exc = new ExcluLock();
        exc.testLock();

       // exc.testCondition();


        //LinkedBlockingQueue queue = new LinkedBlockingQueue();
        //queue.offer(new Object());


    }


    private ExecutorService service = new ThreadPoolExecutor(1,3,1000,TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));




    ReentrantLock lock = new ReentrantLock(false);


    Condition con = lock.newCondition();


    public void testLock() {


        lock.lock();

        TL1 t1 = new TL1(lock);
        service.execute(t1);
        service.execute(t1);
        service.execute(new TL1(lock));
        service.execute(new TL1(lock));
        try {
            TimeUnit.SECONDS.sleep(3);

            System.out.println("----------------");
            lock.unlock();

            service.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void testCondition(){
        try {

            service.execute(new TC1(con));
            service.execute(new TC1(con));
            service.execute(new TC1(con));
            TimeUnit.SECONDS.sleep(5);
            System.out.println("-----------------");
            lock.lock();
            con.signalAll();

            TimeUnit.SECONDS.sleep(5);
            System.out.println("after sleep");


            lock.unlock();
            service.shutdown();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    class TL1 implements Runnable {


        private Lock lock;


        public TL1(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            lock.lock();
            System.out.println(Thread.currentThread().getId() + ":    get lock");
            lock.unlock();
            System.out.println(Thread.currentThread().getId() + ":   unlock");
        }
    }


    class TL2 implements Runnable {

        private Lock lock;

        public TL2(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

        }
    }


    class TC1 implements Runnable {

        private Condition condition;


        public TC1(Condition condition) {
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("---------------- before await:" + Thread.currentThread());
                TimeUnit.SECONDS.sleep(2);
                condition.await();
                System.out.println("------------------ after await:" + Thread.currentThread());
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class TC2 implements Runnable {

        private Condition condition;


        public TC2(Condition condition) {
            this.condition = condition;
        }

        @Override
        public void run() {

        }
    }


}
