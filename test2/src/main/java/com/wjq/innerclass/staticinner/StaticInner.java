package com.wjq.innerclass.staticinner;

/**
 * Created by wangjianqiang on 2017/10/31.
 */
public class StaticInner {

    static class Inner{
        static int i =5;
    }

void f(){

}

    class Inner1{
        void f() {

            Inner1.this.f();
            StaticInner.this.f();
        }
    }


    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();
        System.out.println(inner);
        System.out.println(new StaticInner.Inner());


        System.out.println(Inner.i ++);
        System.out.println(Inner.i);


       StaticInner si = new StaticInner();
       si.new Inner1();




    }

}
