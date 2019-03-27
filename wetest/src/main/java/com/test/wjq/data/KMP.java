package com.test.wjq.data;


import com.alibaba.fastjson.JSON;

/**
 * KMP算法，字符串匹配
 */
public class KMP {



    public static int[] getNext(char[] T) {
        int j = -1;  //前缀
        int i = 0;
        int[] next = new int[T.length];
        next[0] = -1;
        while (i < T.length-1){
            if (-1 == j || T[i] == T[j]) {
                i++;
                j++;
                if (T[i] != T[j]){
                    j = next[j];
                }else {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }
            return next;
    }


    public static void main(String[] args) {

        char[] P = "hhdhdh".toCharArray();  //模式串

        System.out.println(JSON.toJSON(getNext(P)));

        int next[] = getNext(P);
        int i = 0;  //查询串下标位置
        int j = 0;  //模式串下标

        char T[] = "jhhdhdhjeeieiiei".toCharArray();  //查询串

        while (i < T.length && j < P.length) {
            if (-1 == j || T[i] == P[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        System.out.println(i);



















    }



}
