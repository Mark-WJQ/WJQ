package com.test.wjq.bean;

public class TestInit {



    static class A {

        public static int a = 1;

        static {
            a = 2;
        }

    }



    static class B extends A{

        public static int b = a;

    }


    public static void main(String[] args) {

        System.out.println(B.b);
        System.out.println(B.b);
    }


}
