package com.wjq.cglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
@Aspect
@Component
public class AspectJAnnotation {


    @Pointcut("@annotation(CgLIb)")
    public void cut(){

    }

    @Before("cut()")
    public void invoke(){

        System.out.println("before");


    }

}
