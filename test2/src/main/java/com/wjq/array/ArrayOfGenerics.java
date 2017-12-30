package com.wjq.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/18.
 */
public class ArrayOfGenerics {


    public static void main(String[] args) {

        List<String> ls[]= new List[10] ;

        //List la [] = new List[10];
        //ls = la;
       // ls[1] = new ArrayList<Integer>();


        Object[] objects = new Object[10];
        objects[1] = new String();
        objects[0] = new Integer(1);

        Arrays.fill(ls,"");
    }
}
