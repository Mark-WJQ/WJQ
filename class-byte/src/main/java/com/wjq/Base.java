package com.wjq;

import org.omg.SendingContext.RunTime;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class Base {


    public void process(int i){
            System.out.println("process");

    }


    public static void main(String[] args) throws InterruptedException {

        System.out.println(Base.class.getClassLoader());
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];

        System.out.println("pid:" + s);


        TimeUnit.SECONDS.sleep(10);

        System.out.println(System.getProperties().getProperty("user.home"));
    }
}
