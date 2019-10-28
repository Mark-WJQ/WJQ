package com.wjq.asm;

import com.wjq.Base;

public class MyTest {


    public static void main(String[] args) {

        Base base = new Base();
        base.process(1);
    }


    public static void print(){
        System.out.println("------------------------------------test invoke");
        com.wjq.instrument.Base.process();
    }
}
