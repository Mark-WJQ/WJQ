package com.wjq.generic;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/11/29.
 */
public class NewUtil {


    public static <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }


    public static <T>List<T> list(){
        return new ArrayList<T>();
    }

    public static <T>Queue<T> queue (){
        return new LinkedList<T>();
    }


    public static void main(String[] args) {
        NewUtil.<Integer>list();
    }
}
