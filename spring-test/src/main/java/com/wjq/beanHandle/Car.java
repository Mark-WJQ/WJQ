package com.wjq.beanHandle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by wangjianqiang on 2018/10/10.
 */
@Component
public class Car
{
   @PostConstruct
    public static void init(){
        System.out.println("init ----------------");
    }

}
