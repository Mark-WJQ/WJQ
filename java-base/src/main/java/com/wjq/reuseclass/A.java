package com.wjq.reuseclass;

/**
 * Created by wangjianqiang on 2017/10/22.
 */
public class A {


    B b;

    public A(String a) {
        System.out.println("a");
    }

    public A() {
        System.out.println(b);
    }

    static void test(){
        System.out.println("dgdg");
    }

    interface D{

    }

    public class E implements D{

    }

}
