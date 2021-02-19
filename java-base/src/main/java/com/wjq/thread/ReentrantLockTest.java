package com.wjq.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    ReentrantLock lock = new ReentrantLock();




    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();





    public void testCondition(){

        new Thread(new Runnable(){

            @Override
            public void run() {
                lock.lock();

                System.out.println("get c1" + lock.isHeldByCurrentThread());
                try {

                    Thread.sleep(5000);

                    c1.await();

                    System.out.println("c1 notify");
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {
                    lock.unlock();
                }

            }
        }).start();




        new Thread(() -> {

            lock.tryLock();
            System.out.println("c2 get" + lock.isHeldByCurrentThread());



            try {
                //Thread.sleep(5000);
                c1.signal();
                TimeUnit.MILLISECONDS.sleep(5000);
                c2.await();


                System.out.println("c2 notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            finally {
                System.out.println("unlock");
                if (lock.isLocked())
                    lock.unlock();
            }


        }).start();

    }


    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.testCondition();
    }




}
