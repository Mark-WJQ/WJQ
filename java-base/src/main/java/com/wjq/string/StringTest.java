package com.wjq.string;



import java.util.Formatter;

/**
 * Created by wangjianqiang on 2017/11/19.
 */
public class StringTest {

    /**
     * %s
     字符串类型
     %c
     字符类型
     %b
     布尔类型

     %d
     整数类型（十进制）

     %x
     整数类型（十六进制）

     %o
     整数类型（八进制）

     %f
     浮点类型

     %a
     十六进制浮点类型
     %e
     指数类型
     %g
     通用浮点类型（f和e类型中较短的）

     %h
     散列码

     %%
     百分比类型
     %n
     换行符
     %tx
     日期与时间类型（x代表不同的日期与时间转换符
     * @param args
     */

    public static void main(String[] args) {
        System.out.printf("e%d %f",1,1.3D);
        System.out.println();

        Formatter formatter = new Formatter(System.out);

        formatter.format("%-15s %2d %.2s","sssss",5,"edddd");



    }
}
