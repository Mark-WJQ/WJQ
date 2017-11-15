package com.wjq.innerclass;

import java.io.OutputStream;

/**
 * Created by wangjianqiang on 2017/10/29.
 */
public class Outer {

    public Outer() {
    }

    private String s;

    public Outer(String s) {
        this.s = s;
    }

    public class Inner{
        public Inner(int i) {
            this.i = i;
        }

        private int i;

        @Override
        public String toString() {
            return s;
        }
    }

    Inner getInner(){
        return new Inner(2);
    }

    static class StaticInner{

    }



    int getInnerFiled(){
        Inner inner = new Inner(2);
        return inner.i;
    }


}
