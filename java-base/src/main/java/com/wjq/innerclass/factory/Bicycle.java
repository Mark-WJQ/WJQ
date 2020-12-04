package com.wjq.innerclass.factory;

/**
 * Created by wangjianqiang on 2017/10/30.
 */
public class Bicycle implements Cycle {

    private Bicycle() {
    }

    public void draw() {
        System.out.println("draw Bicycle");
    }

    static CycleFactory getFactory = new CycleFactory() {
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}
