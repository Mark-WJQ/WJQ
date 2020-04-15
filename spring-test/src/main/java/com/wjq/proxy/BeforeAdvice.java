package com.wjq.proxy;

import org.springframework.stereotype.Component;

/**
 * 通知，想要做的事
 */
@Component
public class BeforeAdvice implements org.springframework.aop.BeforeAdvice {


    public void before(){
        System.out.println("before advice =========================");
    }


}
