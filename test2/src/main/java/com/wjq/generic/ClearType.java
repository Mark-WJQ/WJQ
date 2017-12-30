package com.wjq.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/5.
 */
public class ClearType<k extends I1> {

    public static  <T extends I1> void test(T t){
        t.m1();
    }

    public static void main(String[] args) {
        test(new C1());
        System.out.println(Arrays.deepToString(new ClearType<C1>().getClass().getTypeParameters()));
    }


}

interface I1{
    public void m1();

    public void m2();
}

class C1 implements I1{

    public void m1() {
        System.out.println("m1");
    }

    public void m2() {
        System.out.println("m2");
    }

    public void m3() {
        System.out.println("m3");
    }
}
