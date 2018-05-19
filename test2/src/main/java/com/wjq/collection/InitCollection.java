package com.wjq.collection;

import javax.swing.plaf.synth.SynthFormattedTextFieldUI;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wangjianqiang on 2017/12/30.
 */
public class InitCollection {



    public static List<String> init(String path){

        //Arrays.asList()
        //List<String> cl = new ArrayList<>(10);
        String a = "sss";
        List<String> cl = Collections.nCopies(10, a);
        System.out.println(cl);
        a= "22";

       List<String> cl1 = cl.subList(0,3);

        System.out.println(cl1);

        System.out.println(cl1);
        System.out.println(cl);


        return null;
    }

    public static void main(String[] args) {


       List list = Collections.checkedList(new ArrayList<>(),String.class);
       list.add("1");
       list.add("2");
        System.out.println(list);
       Collections.reverse(list);
        System.out.println(list);
        list.add("0");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);


       Set set = Collections.<String>singleton("ddd");

        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
        list1.add("222");
        Iterator iterator = list1.iterator();
        list1.add("22");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list1);


        EnumSet<Enum> set1 = EnumSet.allOf(Enum.class);





    }

}

enum Enum{
    A,B,D,F;
}
