package com.wjq.thread;


import java.util.BitSet;
import java.util.concurrent.locks.LockSupport;

/**
 * java同步队列测试
 */
public class AQSTest {


    public static void main(String[] args) {

       /* Thread thread = new Thread(){
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("test park");
            }
        };
        thread.start();
        LockSupport.unpark(thread);
        System.out.println("block-----");*/

        System.out.println(1L<<71);

        BitSet bitSet = new BitSet();
        bitSet.set(71);
        bitSet.set(31);
        bitSet.set(72);
        System.out.println(bitSet);


    }


}
