package com.wjq.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {



    public PI getProxy(PIimpl pi){


       return PI.class.cast( Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{PI.class},new Handler(pi)));


    }


    class Handler implements InvocationHandler{

        private PI target;


        public Handler(PI target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(target,args);
        }
    }



    static class PIimpl implements PI{

        @Override
        public void test() {
            System.out.println("==========proxy=========");
        }
    }


    public static void main(String[] args) {

        ProxyTest test = new ProxyTest();

        PIimpl pi = new PIimpl();

        test.getProxy(pi).test();


    }





}



interface PI{


    void test();
}



