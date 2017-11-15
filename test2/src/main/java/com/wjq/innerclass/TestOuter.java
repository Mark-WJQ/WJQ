package com.wjq.innerclass;

/**
 * Created by wangjianqiang on 2017/10/29.
 */
public class TestOuter {

    public static void main(String[] args) {
        Outer outer = new Outer("hello");
        Outer.Inner inner = outer.getInner();
        System.out.println( inner.toString());
        System.out.println(outer.getInnerFiled()  );

        Outer.StaticInner si = new Outer.StaticInner();
    }
}
