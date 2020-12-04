package com.wjq.innerclass.staticinner;

/**
 * Created by wangjianqiang on 2017/10/31.
 */
public class StaticTest {


    static class t1{
        static class t2{
            void f(){};
        }
        void f(){}
    }

    public static void main(String[] args) {
        StaticTest.t1 t = new StaticTest.t1();
    }
}
