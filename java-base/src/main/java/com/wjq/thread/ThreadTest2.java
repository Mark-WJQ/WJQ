package com.wjq.thread;

/**
 * Created by wangjianqiang on 2018/5/7.
 */
public class ThreadTest2 {

  static Object synObj = new Object();

     void m1(){
         synchronized(synObj) {
           for (int i = 0; i < 5; i++) {
               System.out.println("m1");
               Thread.yield();
           }
       }
    }

    void m2(){
        synchronized (synObj){
            for (int i = 0; i< 5;i++) {
                System.out.println("m2");
                Thread.yield();
            }
        }
    }

   static ThreadLocal<Integer> local = new ThreadLocal<>();
    static ThreadLocal<String> local1 = new ThreadLocal<>();
    public static void main(String[] args) {
       /* ThreadTest2 test2 = new ThreadTest2();
        ThreadTest2 test = new ThreadTest2();
        new Thread(){

            @Override
            public void run() {
               test2.m1();
            }
        }.start();

        test.m2();*/


        local.set(111);
        local1.set("hhhh");

        System.out.println(local1.get());
        System.out.println(local.get());
    }





}
