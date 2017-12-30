package com.wjq.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/10.
 * 通配符
 */
public class Covariance {




    public static void main(String[] args) {
        //数组的协变,可以向导出类型的数组赋予基类型的引用
        Number[] ni= new Integer[10];
        ni[0] = 10;
        //可以通过编译，运行时会报错
        ni[1] = 2.33;
        System.out.println(ni[0]);
        //java.lang.ArrayStoreException: java.lang.Double
        System.out.println(ni[1]);

        //编译错误，Integer的list不能向上转型为Number的list
       // List<Number> nl = new ArrayList<Integer>();
        //编译通过，Integer的list 可以向上转型为继承Number的子类的List
        List<? extends Number> nl = new ArrayList<Integer>(Arrays.asList(new Integer(1)));
        //编译错误，不能添加任意类型的对象，即便实际上是IntegerList，协变不起作用
        //nl.add(1);
        //nl.add(new Object());
        Number n = nl.get(0);

        //错误，返回类型只能是边界
        //Integer i = nl.get(1);
        //可以直接调用，应为该方法不涉及范型，传入参数为Object
        nl.contains(1);


        List<? super Integer> il = new ArrayList<Number>();
        //不能添加
        //il.add(new Double(1));
        il.add(new Integer(1));


        List<? super BB> bbl = new ArrayList<AA>();
        //引用不能指向子类
        //List<? super BB> ccl = new ArrayList<CC>();

        bbl.add(new CC());
    }
}


class AA{

}


class BB extends AA{

}


class CC extends BB{

}

interface DD<T>{

}

class E implements DD<Integer>{

}

class F extends E implements DD<Integer>{

}