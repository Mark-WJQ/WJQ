package com.wjq.abstracttest;

import java.util.Random;

/**
 * Created by wangjianqiang on 2017/10/28.
 */
public class RandomDoubles {

    private static Random rand = new Random(47);
    public double next(){
        return rand.nextDouble();
    }


}
