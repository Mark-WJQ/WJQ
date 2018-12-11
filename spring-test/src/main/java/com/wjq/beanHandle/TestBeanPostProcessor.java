package com.wjq.beanHandle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by wangjianqiang on 2018/9/14.
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {


    public TestBeanPostProcessor() {
        System.out.println("初始化==========TestBeanPostProcessor" );
    }
}
