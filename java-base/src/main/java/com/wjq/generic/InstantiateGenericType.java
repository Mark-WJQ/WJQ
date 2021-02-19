package com.wjq.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianqiang on 2017/12/6.
 */
public class InstantiateGenericType {

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
    }
}


class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            this.x = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


class ClassFactoryWithArg<T,K>{
    T x;

    public ClassFactoryWithArg(Class<T> kind,Class<K> arg) {
        try {
            System.out.println(Arrays.deepToString(kind.getConstructors()));
            //kind.getDeclaredConstructor()
            this.x = kind.getDeclaredConstructor(arg).newInstance(arg.newInstance());;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ClassFactoryWithArg<WithArg,? extends String> wa = new ClassFactoryWithArg(WithArg.class,"dddd".getClass());
        wa.x.k = "12";
        System.out.println(wa.x.k);
    }
}

class WithArg{
    String k;

    public WithArg() {
    }

    public WithArg(String k) {
        this.k = k;
    }
}


interface FactoryI<T>{
    T create();
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F f){
        x = f.create();
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}

class IntegerFactory implements FactoryI<Integer>{

    public Integer create() {
        return new Integer(0);
    }
}


class FactoryCapture{
    Map<String,FactoryI<?>> factoryIMap = new HashMap<String,FactoryI<?>>();

    public void addFactory(String name,FactoryI<?> fatoryI){
        factoryIMap.put(name,fatoryI);
    }

    public Object createNew(String name,int arg){
        return factoryIMap.get(name).create();
    }

}
