package com.wjq.jvm;

public class FieldResolution {


    interface I0{
        int a = 0;
    }


    interface I1 extends I0{
        int a = 1;
    }


    interface  I2{
        int a = 2;
    }


    static class Parent implements I1{
        public static int a = 3;
    }



}
