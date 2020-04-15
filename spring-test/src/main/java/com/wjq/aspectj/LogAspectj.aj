package com.wjq.aspectj;

public aspect LogAspectj {

    pointcut beforeExecute():call(* LogTestAspect.log(*));

    Object around() :beforeExecute() {
        System.out.println("before log4j log");
        Object retVal = null;
        retVal = proceed();
        System.out.println("after log4j log--------------");
        return retVal;
    }



}
