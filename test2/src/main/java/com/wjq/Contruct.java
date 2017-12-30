package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/19.
 */
public class Contruct {

    String s;

    public static void main(String[] args) throws ClassNotFoundException {


       Class o = Class.forName("com.alibaba.fastjson.JSONObject");


        System.out.println(o.getMethods()[0]);


        Contruct contruct = new Contruct();

        System.out.println(contruct.s);
    }

}
