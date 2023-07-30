package com.test.wjq.bean;

import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Annotation;

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


    @interface IA{

        /*interface getI() default {
        }*/
        Class getC() default Comparable.class;
    }








    public static void main(String[] args) {

        System.out.println(B.b);
        System.out.println(B.b);
    }


}
