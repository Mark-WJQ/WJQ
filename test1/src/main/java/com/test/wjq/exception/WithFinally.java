package com.test.wjq.exception;


/**
 * Created by wangjianqiang on 2017/11/11.
 */
public class WithFinally {

    public static void main(String[] args) {
        boolean onoff = false;

        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally runtimeException");
        }
    }
}
