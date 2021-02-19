package com.wjq.thread;


import java.util.concurrent.locks.StampedLock;

/**
 * @see java.util.concurrent.locks.StampedLock
 *
 */

public class StampedLockTest {



    private static StampedLock lock = new StampedLock();


    public static void main(String[] args) {

    lock.readLock();
    lock.tryOptimisticRead();




    }

}
