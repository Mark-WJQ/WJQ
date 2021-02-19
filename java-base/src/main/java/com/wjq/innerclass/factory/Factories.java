package com.wjq.innerclass.factory;

import java.math.BigDecimal;

/**
 * Created by wangjianqiang on 2017/10/30.
 */
public class Factories {

    public static void draw(CycleFactory cf){
        cf.getCycle().draw();
    }


    public static void main(String[] args) {
        draw(Unicycle.getFactory);
        draw(Bicycle.getFactory);
    }
}
