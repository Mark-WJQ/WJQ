package com.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/12/30.
 */
public class TestList {


    public static List<String> fillArrayList(){
        List<String> list = new ArrayList<>();
        list.addAll(Countries.names());
        return list;
    }

    public static List<String> fillLinkList(){
        List<String> list = new LinkedList<>();
        list.addAll(Countries.names());
        return list;
    }


    public static void main(String[] args) {
        List<String> list = fillArrayList();
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        List list1 = fillLinkList();
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collections.shuffle(list,new Random(1));
        System.out.println(list);
        System.out.println(list1);


        ListIterator<String> li = list.listIterator(list.size());
        ListIterator<String> li1 = list1.listIterator();
        int aindex = 0;
            while (li1.hasNext()) {
                list.add(aindex, li1.next());
                aindex += 2;
            }

        System.out.println("-----------------------");
        System.out.println(list);




    }


}
