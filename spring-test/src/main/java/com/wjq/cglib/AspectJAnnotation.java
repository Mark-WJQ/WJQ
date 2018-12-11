package com.wjq.cglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.reflect.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
@Aspect
@Component
public class AspectJAnnotation {


    @Before("@annotation(cgLIb))")
    public void invoke(CgLIb cgLIb){

        System.out.println("before");


    }

}
