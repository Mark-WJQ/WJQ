package com.test.wjq.exception;

/**
 * Created by wangjianqiang on 2017/11/14.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            //派生类的构造器如果不显示申明时不能捕获基类构造器抛出的异常
            new T2();
        }finally {

        }
    }

}

class E1 extends Exception{

}

class E2 extends Exception{}


class T1{
    public T1() throws E1 {
    }
}

class T2{
    public T2() {
    }
}

