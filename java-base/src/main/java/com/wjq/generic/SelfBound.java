package com.wjq.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/10.
 */
public class SelfBound {

    public static void main(String[] args) {
        SelfBound1 sb = new SelfBound2();
        SelfBound2 sb2 = new SelfBound2();
        sb.f1(sb2);
        System.out.println(sb2.i);

        List list = new ArrayList();
        list = Collections.checkedList(list,String.class);
        list.add(1);
        //Collections.checkedCollection()
    }
}


abstract class SelfBound1  <T extends SelfBound1<T>>{
    public abstract T f(T t);


    public void f1(T t){
        System.out.println( f(t).getClass().getSimpleName());
    }

}


class SelfBound2 extends SelfBound1<SelfBound2>{

    int i;

    @Override
    public SelfBound2 f(SelfBound2 selfBound2) {
        selfBound2.i = 10;
        return selfBound2;
    }
}
