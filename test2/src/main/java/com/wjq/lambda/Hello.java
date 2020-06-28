package com.wjq.lambda;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangjianqiang24
 * @date 2020/6/23
 */
public class Hello {

    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };
    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            String var = "----------------";
            System.out.println(this + var);
        }
    };
    public static void main(String[] args) {
        new Hello().r1.run();
        new Hello().r2.run();
        new Hello().r3.run();

        ReentrantLock lock = new ReentrantLock();
        Thread.currentThread().isInterrupted();

    }
    public String toString() { return "Hello Hoolee"; }

}
