package com.test.wjq.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangjianqiang on 2017/11/19.
 */
public class StringPattern {


    public static void main(String[] args) {
        String s = "I am a coder.";

        //以大写字母开头，以.结尾
        System.out.println(s.matches("^[A-Z].*\\.$"));


        String d = "1d3-345";
        Pattern p =  Pattern.compile("\\d{3,5}");
        Matcher matcher = p.matcher(d);
        //matches 全局匹配，只有整个串都匹配表达式为true,
        System.out.println(matcher.matches());
        //需要重置开始的位置，否则会从下一个位置开始匹配，因为matches已经匹配过一次
        matcher.reset();
        System.out.println(matcher.find());
        //lookingAt 只匹配开始的位置
        System.out.println(matcher.lookingAt());

        System.out.println("------------------s1 matche--------------");
        String s1 = "Java hasssss regular expressions";
        p =  Pattern.compile("^Java");
         matcher = p.matcher(s1);
        System.out.println("^Java matcher.find() = " + matcher.find());
        System.out.println("s1.matches(\"^Java\") = " + s1.matches("^Java"));
        System.out.println("s1.matches(\"\\\\Breg.*\") = "+s1.matches("\\breg.*"));
        System.out.println("s1.matches(\"n.w\\\\s+h(a|i)s\") =" + s1.matches("n.w\\s+h(a|i)s"));
        System.out.println(Arrays.deepToString(s1.split("\\b")));
        System.out.println(s1.matches("s{4,}"));
        p =  Pattern.compile("s{4}");
        matcher = p.matcher(s1);
        System.out.println(matcher.find());


        String s2 = "Arline ate eight apples and one orange ehile Anita hadn't any";
        p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        matcher = p.matcher(s2);
        System.out.println(matcher.matches());
        System.out.println(matcher.find());






    }
}
