package com.wjq.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/10.
 */
public class GenericTest {
    //逆变
   public static  <T> void t3 (Generic1<? super T> t,T t1){
        t.t1(t1);
    }

    //协变
    public static <T> void t4(Generic2<? extends T> t,T t1){
       t.t2();
       //协变因为不知道具体的上限类型不可用
       //t.setT(t1);
    }


    public static void main(String[] args) {
        t3(new Generic1<A2>(),new A2());

        //t4(new Generic2<A1>());
    }
}


class Generic1<T> {
    public void t1(T t){

    }
}

class Generic2<T>{
    T t;
    public T t2() {
       return t;
    }

    public void setT(T t){
        this.t = t;
    }
}

class A1{

}

class A2 extends A1{

}

class A3 extends A1{

}

class A4{

    static List<?> l = new ArrayList<Integer>();

    public static void main(String[] args) {
       // l.add(1);
    }

}