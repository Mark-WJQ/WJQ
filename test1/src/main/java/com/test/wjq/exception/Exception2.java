package com.test.wjq.exception;

/**
 * Created by wangjianqiang on 2017/11/14.
 */
public class Exception2  {

    public static void main(String[] args) {
        Exception4 e4 = new Exception4();
        e4.test();
        Exception3 e3 = new Exception3();
       // e3.test();
    }

}




class Exception3{

    void test() {

    }

}

interface Exceptionf{

    void test() throws RuntimeException;

}


class Exception4 extends Exception3 implements Exceptionf{

    //导出类重写继承的方法时其抛出的异常范围不能大于基类中方法的异常，符合多态,也可不抛出异常
    //如果基类中的方法没有抛出异常，子类中重写的方法也不应该抛出异常
    @Override
    public void test(){

    }
}

