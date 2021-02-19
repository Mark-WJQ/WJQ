package com.wjq.generic;

/**
 * 边界
 * Created by wangjianqiang on 2017/12/10.
 */
public class Boundary {

    static <T extends A> void testA(T t){
        t.a();
    }

    static <T extends B> void testB(T t){
        t.b();
    }

    static <T extends A & B> void testAB(T t){
        t.a();
        t.b();
    }

    public static void main(String[] args) {

        C c = new C();

        testA(c);
        testB(c);
        testAB(c);

        D d = new D();
        //编译不通过，不符合边界
       // testAB(d);
        testA(d);

    }

}


 interface A{

    public void a();

 }

 interface B{
     public void b();

 }

 class C implements A,B{

     public void a() {
         System.out.println("a");
     }

     public void b() {
         System.out.println("b");
     }
 }

class D implements A{

    public void a() {
        System.out.println("Da");
    }
}
