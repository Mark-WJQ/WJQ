package com.test.wjq.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/11/6.
 */
public class CollestionTest {





    public static void main(String[] args) {

        List<T> tList = new ArrayList<T>();

        Collections.addAll(tList,new T1());

        Arrays.<P>asList();

        //List<String>.class;

        //tList.retainAll()
        //tList.replaceAll(t -> t);

        List<Integer> li = new ArrayList<Integer>();
    }
}


class T{
    int i;

    public void setT(){}
}
class P{}

class T1 extends T{

}
class P1 extends P{}