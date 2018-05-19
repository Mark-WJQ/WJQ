package com.oujb.sms.encry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2018/3/6.
 */
public class FileService {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        System.out.println(list.size());
        list.removeIf(i -> !(i==1));

        System.out.println(list.size());
    }
}
