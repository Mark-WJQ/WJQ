package com.wjq.aspectj;

public class AspectJMain {

    public static void main(String[] args) {

        LogTestAspect.log("dhdhhhh");

        LogTestAspect logTestAspect = new LogTestAspect();
        logTestAspect.instanceLog("---------------");

        AnotherAnnoTest anotherAnnoTest = new AnotherAnnoTest();
        anotherAnnoTest.test();

    }
}
