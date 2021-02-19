package com.wjq.dataStruct;

import java.util.Arrays;
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



    static class Solution {
        public static int lengthOfLongestSubstring(String s) {

            if (s.length() == 0 || s.length() == 1){
                return s.length();
            }

            char[] chars = s.toCharArray();
            int[] arr = new int[128];
            Arrays.fill(arr,-1);

            int start = 0;
            int end = 0;
            int l = start - end;
            for(int i = 0; i < chars.length;i++){
                char c = chars[i];
                if(arr[c] == -1){
                    arr[c] = i;
                }
                else {
                    if (i - arr[c] > l){
                        start = arr[c];
                        end = i - 1;
                        l = end - start + 1;
                    }
                    arr[c] = i;
                }
            }
            return l;
        }


        public static void main(String[] args) {
            lengthOfLongestSubstring("abc");
        }
    }




}
