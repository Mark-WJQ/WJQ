package com.test.wjq.exception;

/**
 * Created by wangjianqiang on 2017/11/11.
 */
public class Exception1 {

    void f() throws Exception {
        throw new Exception();
    }

    void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            //e.printStackTrace();
            e.fillInStackTrace();
            e.initCause(new NullPointerException());
            throw e;
        }
    }


    public static void main(String[] args) {
        Exception1  e1 = new Exception1();
        try {
            e1.g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
