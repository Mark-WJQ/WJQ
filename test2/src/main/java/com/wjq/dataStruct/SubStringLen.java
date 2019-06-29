package com.wjq.dataStruct;

import java.util.HashMap;
import java.util.Map;

public class SubStringLen {


    public static int maxSub(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        //开始索引下边
        Integer index = 0;
        int maxLenth = 0;
        Integer lastIndex = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                index = map.get(chars[i]);
                if (index >= lastIndex) {
                    maxLenth = Math.max(i - lastIndex, maxLenth);
                    //获取匹配到的上一个索引位置
                    lastIndex = index + 1;
                }
            }
            map.put(chars[i], i);
        }
        maxLenth = Math.max(chars.length - lastIndex, maxLenth);
        return maxLenth;
    }


    public static void main(String[] args) {
        System.out.println(maxSub("au"));
    }


}
