package com.test.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/11/7.
 */
public class ListIteratorTest {


    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        Random random = new Random(100);

        for (int i = 0;i < 10 ;i++){
            l1.add(random.nextInt());
        }

        System.out.println(l1);


        ListIterator<Integer> listIterator = l1.listIterator(l1.size());
        List<Integer> l2 = new ArrayList<Integer>();
        while (listIterator.hasPrevious()){
            //System.out.println(listIterator.hasNext());
           // System.out.println( "nextIndex:" + (listIterator.hasNext() ? listIterator.nextIndex() : 0)+ ";previous:" + listIterator.previousIndex() );
            l2.add(listIterator.previous());
            listIterator.add(10);
            if (l1.size() > 20)
                break;
        }
        System.out.println(l1);

        System.out.println(l2);


        listIterator.set(100);
        System.out.println(l1);


        LinkedList ll = new LinkedList();
        ll.poll();
        ll.pop();





    }
}
