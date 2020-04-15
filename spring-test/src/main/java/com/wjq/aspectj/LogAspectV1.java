package com.wjq.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspectV1 {

    @Pointcut("execution(* com.wjq.aspectj.LogTestAspect.log(String))")
    public void pointCut(){}


    @After("pointCut()")
    public void testAfter(){
        System.out.println("annotion after ------------");
    }







}
