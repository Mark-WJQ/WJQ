package com.wjq.lock;

import java.util.concurrent.TimeUnit;

public class TestSychronized {




    private Object obj = new Object();


    public static void main(String[] args) {


        TestSychronized t = new TestSychronized();
        t.lock();

    }


    public void lock(){

        synchronized (obj){

            try {
                System.out.println("enter sync");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }




}
