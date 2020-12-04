package com.wjq.jvm;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjianqiang on 2018/4/15.
 */
public class TestSyn {

    public final static String aaa = "a";

    static Object object = new Object();
    public static void test(Syn syn) throws InterruptedException {
        synchronized (syn){
            System.out.println(Thread.currentThread().getName() + syn);
            Thread.sleep(5000L);
        }
    }


    public static void main(String[] args) {
        Integer a = 200;
        Integer b = 200;
        Integer c = 400;
        Long g = 400L;

        System.out.println(g.equals(a +b));

        System.out.println(c.equals(a +b));
        System.out.println(a == b);

        System.out.println(c == a+b);

        /*ExecutorService pool = Executors.newFixedThreadPool(3);
        Syn syn = new Syn();
        for (int i = 0; i < 10 ; i++) {

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
        pool.shutdown();*/

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