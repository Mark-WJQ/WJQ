package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/5.
 */
public class SimpleProxyDemo {

    public static void consumer(Interface i){
        i.doSomething();
        i.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

}


interface Interface{
    void doSomething();
    void somethingElse(String args);
}

class RealObject implements Interface{

    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String args) {
        System.out.println("somethingElse " + args);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String args) {
        System.out.println("SimpleProxy somethingElse " + args);
        proxied.somethingElse(args);
    }
}
