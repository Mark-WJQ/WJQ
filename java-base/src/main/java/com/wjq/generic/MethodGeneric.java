package com.wjq.generic;


import java.util.Collections;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/11/29.
 */
public class MethodGeneric {


    public static <T>  T get(T t){
        return t;
    }


    public static <T,K,M> void f(T t,K k,M m){
        System.out.println("T " +t.getClass().getSimpleName() + "\n" + "K " + k.getClass().getSimpleName() + "\n" + "M " + m.getClass().getSimpleName() );
    }

    public static void main(String[] args) {
        System.out.println(get(10));

        f(new MethodGeneric(),10,new Coffee());


        
    }
}
