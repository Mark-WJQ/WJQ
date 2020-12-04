package com.wjq;

import java.util.Random;

/**
 * Created by wangjianqiang on 2017/10/5.
 */
public class ClassInitialization {




    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;

        System.out.println("After creating Initable ref");
        //在第一次调用静态变量时，会首先初始化对象，获取静态变量，然后执行静态代码块

        System.out.println(Initable.staticFinal);

        System.out.println(Initable.staticFinal2);

        System.out.println(Initable2.staticNonFinal);

        Class in3 = Class.forName("com.wjq.Initable3");

        System.out.println("After creating Initable3");

        System.out.println(Initable3.staticNonFinal3);
    }

}

class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    public Initable() {
        System.out.println("初始化");
    }

    static {
        System.out.println("initializing Initable");
    }
}


class Initable2{
    static int staticNonFinal = 147;

    public Initable2() {
        System.out.println("初始化2");
    }

    static {
        System.out.println("initializing Initable2");
    }
}

class Initable3 {

    static int staticNonFinal3 = 74;

    public Initable3() {
        System.out.println("初始化3");
    }

    static {
        System.out.println("initializing Initable3");
    }
}



