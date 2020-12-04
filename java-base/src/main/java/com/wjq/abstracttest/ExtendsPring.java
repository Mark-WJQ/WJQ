package com.wjq.abstracttest;

/**
 * Created by wangjianqiang on 2017/10/28.
 */
public class ExtendsPring extends AbstractPrint {
    int i = 16;

    void print() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        new ExtendsPring().print();


        /**
         *
         * 在初始化对象时会首先为所有的变量分配内存并赋予初值0或null，而具体的复制灰暗初始化顺序处理
         *
         * 0
         16
         */
    }
}
