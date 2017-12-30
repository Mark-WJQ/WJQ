package com.wjq.generic;

import java.lang.reflect.Array;

/**
 * Created by wangjianqiang on 2017/12/7.
 */
public class GenericArray<T> {


    private T[] array;

    public GenericArray(int sz) {
        this.array = (T[]) new Object[sz];
    }


    private void put(int index,T t){
        array[index] = t;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray ga = new GenericArray<Integer>(10);
        ga.put(0,1);
        Integer[] i = (Integer[]) ga.rep();

    }
}

class GenericArray2<T>{
    private Object[] array;

    public GenericArray2(int sz ) {
        this.array = new Object[sz];
    }


    private void put(int index,T t){
        array[index] = t;
    }

    public T get(int index){
        return (T) array[index];
    }

    public T[] rep(){
        return (T[]) array;
    }


    public static void main(String[] args) {
        GenericArray2<Integer> ga2 = new GenericArray2<Integer>(10);
        ga2.put(0,10);
        System.out.println(ga2.get(0).getClass());
        //编译通过。但返回的实际类型是Object[]
       //Integer[] i = ga2.rep();
        System.out.println(ga2.rep().getClass());


    }

}


class GenericArrayWithTypeToken<T>{

    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type,int sz) {
        this.array = (T[]) Array.newInstance(type,sz);
    }

    public void put(int index,T t ){
        array[index] = t;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken genericArrayWithTypeToken = new GenericArrayWithTypeToken(Integer.class,10);
        genericArrayWithTypeToken.rep();
    }
}
