package com.wjq.beanHandle;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by wangjianqiang on 2018/10/10.
 */
@Component
@Primary
public class Car
{


    private Integer p1;

   @PostConstruct
    public static void init(){
        System.out.println("init ----------------");
    }


    public static void main(String[] args) {

    }
}
