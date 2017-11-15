package com.wjq.reuseclass;

/**
 * Created by wangjianqiang on 2017/10/22.
 *
 *
 * 在初始化子类时，先初始化父类中的内容，如果父类中只有带参构造器，子类必须有相同的参数的构造器并显示的首先调用父类的构造器
 *
 *
 */
public class C extends A {

    public C(String c) {
        System.out.println('c');
    }

    public static void main(String[] args) {
        new C("hello");
        C.test();
    }
}
