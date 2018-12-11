package com.wjq.abstracttest;

/**
 * Created by wangjianqiang on 2018/6/9.
 */
public class ConstantPoolTest extends AbstractPrint{


    int k =1;
    @Override
    void print() {
        System.out.println("hahahah");
    }


    public static void main(String[] args) {
        System.out.println(new RandomDoubles().ss);
        System.out.println(new ConstantPoolTest().i);
    }
}




