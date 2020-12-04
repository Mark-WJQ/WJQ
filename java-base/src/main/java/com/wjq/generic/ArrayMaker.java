package com.wjq.generic;

import java.lang.reflect.Array;

/**
 * Created by wangjianqiang on 2017/12/6.
 */
public class ArrayMaker<T> {

    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {

        this.kind = kind;
    }

    T[] creat(int size){
        return (T[]) Array.newInstance(kind,size);
    }


    public static void main(String[] args) {
        System.out.println(Array.newInstance(Integer.class,5).getClass());

    }

}
