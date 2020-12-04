package com.wjq.innerclass;

/**
 * Created by wangjianqiang on 2017/11/2.
 */
public class C {

    class A{
        A(){
            System.out.println("");
        }
    }

}




class D extends C.A{

    D(C c){
        c.super();
    }

}


class E{
    class F{

        public F() {
        }

        F(int i){

        }
    }
}


class G{
    class H extends E.F{


        H(E e){
            e.super();
        }

        H(E e,int i) {
            e.super(i);
        }
    }
}

