package com.wjq.array;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/12/21.
 */
public class TestArray11 {

    public static void main(String[] args) {
        int[] i1 = new int[10];
        //自动包装机制不能应用于数组
       // Integer[] is = i1;

        TA[] ta1 = new TA[]{new TA(1),new TA(1),new TA(1)};
        TA[] ta2 = new TA[3];
        Arrays.fill(ta2,new TA(1));
        System.out.println( Arrays.equals(ta1,ta2));

        TA[][] ta3 = new TA[][]{{new TA(1),new TA(1),new TA(1)},{new TA(1),new TA(1),new TA(1)}};
        TA[][] ta4 = new TA[][]{{new TA(1),new TA(1),new TA(1)},{new TA(1),new TA(1),new TA(1)}};
        System.out.println(Arrays.equals(ta3,ta4));
        System.out.println(Arrays.deepEquals(ta3,ta4));
        Arrays.sort(ta1, new Comparator<TA>() {
            @Override
            public int compare(TA o1, TA o2) {
                return 0;
            }
        });

        Collections.reverseOrder();
        //java.lang.ClassCastException: com.wjq.array.TA cannot be cast to java.lang.Comparable
        //Arrays.binarySearch(ta1,new TA(1));

        List<String>[] l = new List[10];
        List[] l1 = new List[10];
        l = l1;
        l[1] = new ArrayList<>();

        System.out.println(l);

    }



}


class TA{
    private int a;

    public TA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        return this.a == ((TA)obj).a;
    }
}
