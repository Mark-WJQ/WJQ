package com.wjq.innerclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/11/1.
 */
public class B {

    List<U> us = new ArrayList<U>();

    void b1(U u){
        us.add(u);
    }

    void b2(U u){
        for (int i = 0;i < us.size(); i++){
            System.out.println(u.toString() + us.get(i));
            if (u.equals(us.get(i))){
                us.set(i,null);
            }
        }

    }

    void b3(){
        for (U u: us){
            System.out.println(u);
        }
    }


    public static void main(String[] args) {

        B b = new B();

        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        A a4 = new A();
        A a5 = new A();
        A a6 = new A();


        b.b1(a1.a(1,"a"));
        b.b1(a2.a(2,"a"));
        b.b1(a3.a(3,"a"));
        b.b1(a4.a(4,"a"));
        b.b1(a5.a(5,"a"));
        b.b1(a6.a(6,"a"));
        b.b3();
        System.out.println("---------------------");

        b.b2(a1.a(1,"a"));

        b.b3();
    }
}
