package com.wjq.exception;

public class ExceptionTest {


    public static void main(String[] args) {

        ExceptionTest test = new ExceptionTest();

        try {

            test.test();

        }catch (Throwable e){
            System.out.println("---------------");
        }

    }



    public void test(){

        try {
            System.out.println(1/0);
        }finally {
            System.out.println("1/0 ============");
        }
    }


}
