package com.wjq.generic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/10.
 */
public class HolderList {

    static <T> void f1(Holder<List<?>> hl){

        List<?> l = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

        hl.setItem(l);

       Object obj = hl.getItem().get(0);
        System.out.println((Integer)obj);

    }

    public static void main(String[] args) {
        f1(new Holder<List<?>>());

       // Arrays.<Byte>asList(1,2);

        App app = new App(1,2);
        JSONArray ja = new JSONArray();
        ja.add(app);
        List<App> la = List.class.cast(ja);
        System.out.println(la.get(0));



    }

}


class Holder<T>{


    T item;

    public Holder() {
    }

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}


class App{
    int a ;
    int b;
    public App(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "App{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}