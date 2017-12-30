package com.wjq.generic;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/11/29.
 */
public class Generators<T> {

     private Class<T> type;

    public Generators(Class<T> type) {
        this.type = type;
    }

    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for (int i = 0 ; i < n ; i ++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n){
        for (int i = 0 ; i < n ; i ++){
            coll.add(gen.next());
        }
        return coll;
    }


    public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> gen, int n){
        for (int i = 0 ; i < n ; i ++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Generators<Integer> g = new Generators(Integer.TYPE);

    }
}



