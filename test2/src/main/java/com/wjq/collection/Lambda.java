package com.wjq.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by wangjianqiang on 2018/1/19.
 */
public class Lambda {


    public static void test(List<String> list, Predicate<String> tester, Consumer<String> nlock){
        for (String s : list) {
            if (tester.test(s)) {
                nlock.accept(s);
            }
        }
    }

    public static void main(String[] args) {

        test(Arrays.asList("aa","bbb","ccc"), s -> s.equals("aa"),s -> System.out.println(s));

    }

}
