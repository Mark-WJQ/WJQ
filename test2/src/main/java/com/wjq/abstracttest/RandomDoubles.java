package com.wjq.abstracttest;

import java.util.Random;

/**
 * Created by wangjianqiang on 2017/10/28.
 */
public class RandomDoubles {

    public int ss = 10;

    private static Random rand = new Random(47);
    public double next(){
        return rand.nextDouble();
    }

    static {
       i = 0;
    }
    static int i =1;


    public static void main(String[] args) {
        System.out.println(ConstantPoolTest.i);
        System.out.println(i);
    }


}
