package com.wjq.innerclass;

/**
 * Created by wangjianqiang on 2017/10/30.
 */
public class SecondClass {

    FirstCladd getFirst(final int i){
        return new FirstCladd(i){
            @Override
            public void setI(int i) {
                super.setI(5);
            }
        };
    }


    public static void main(String[] args) {
        SecondClass sc = new SecondClass();
        FirstCladd fc = sc.getFirst(2);
        fc.setI(4);
        System.out.println( fc.getI());
    }
}
