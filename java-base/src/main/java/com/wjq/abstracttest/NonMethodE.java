package com.wjq.abstracttest;

/**
 * Created by wangjianqiang on 2017/10/28.
 */
public class NonMethodE extends NonMethod {


    void method(){
        System.out.println("method");
    }

    static void addMethod(NonMethod nonMethod){
        ((NonMethodE)nonMethod).method();
    }
}
