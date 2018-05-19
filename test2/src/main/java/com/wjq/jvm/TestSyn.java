package com.wjq.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjianqiang on 2018/4/15.
 */
public class TestSyn {

    static Object object = new Object();
    public static void test(Syn syn) throws InterruptedException {
        synchronized (syn){
            System.out.println(Thread.currentThread().getName() + syn);
            Thread.sleep(5000L);
        }
    }


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10 ; i++) {
            Syn syn = new Syn();
            syn.a = "a";
            syn.b = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        test(syn);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();

    }

}


class Syn{
    String a;
    Integer b;

    @Override
    public boolean equals(Object obj) {
        return a.equals(((Syn)obj).a);
    }

    @Override
    public String toString() {
        return a + b;
    }

    @Override
    public int hashCode() {
        return a.hashCode();
    }
}