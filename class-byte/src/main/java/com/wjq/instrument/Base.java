package com.wjq.instrument;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Base {


    public Base() {
       Byte[] bytes = new Byte[1024];
    }

    public static void main(String[] args) throws InterruptedException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];

        System.out.println("pid:" + s);

        while (true){
            TimeUnit.SECONDS.sleep(5);

            HashMap map = new HashMap();
            map.put("haha","hdhdh");

            System.out.println(Thread.currentThread().getContextClassLoader());
            process();
        }


    }

    public static void process() {
        test();
        System.out.println(LocalDateTime.now() +  "process");

    }



    static void test(){
        System.out.println("========test");
    }

}