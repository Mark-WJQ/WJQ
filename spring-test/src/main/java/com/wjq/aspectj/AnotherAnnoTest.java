package com.wjq.aspectj;

@LogAnno
public class AnotherAnnoTest {
    public void test(){

        System.out.println("AnotherAnnoTest =====================");
        InnerClass.t1();
    }

    @LogAnno
    static class InnerClass{


        public static void t1(){
            System.out.println("---------------------------------- InnerClass");
        }

    }
}
