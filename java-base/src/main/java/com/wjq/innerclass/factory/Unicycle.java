package com.wjq.innerclass.factory;

/**
 * Created by wangjianqiang on 2017/10/30.
 */
public class Unicycle implements Cycle {

    private Unicycle() {
    }

    public void draw() {
        System.out.println("draw Unicycle");
    }

    static CycleFactory getFactory = new CycleFactory() {
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}
