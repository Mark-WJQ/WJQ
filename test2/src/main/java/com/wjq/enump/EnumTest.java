package com.wjq.enump;

import java.util.EnumSet;

/**
 * Created by Administrator on 2016/11/23.
 */
public enum EnumTest {

    RED,
    GREEN,
    BLUE;


   // EnumTest(String s, String s1, String aaaaa) {
    //}


    public static void main(String[] args) {

        EnumSet<EnumTest> set = EnumSet.of(BLUE,RED);

        System.out.println(set);


    }

}
