package com.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangjianqiang on 2017/11/5.
 */
public class RPCBootStrap {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }
}
