package com.test.wjq.spi;

import java.util.ServiceLoader;

public class JavaSpiTest {


    public static void main(String[] args) {
       ServiceLoader<Rebot> loader = ServiceLoader.load(Rebot.class);
       loader.forEach(Rebot::sayHello);
    }
}
