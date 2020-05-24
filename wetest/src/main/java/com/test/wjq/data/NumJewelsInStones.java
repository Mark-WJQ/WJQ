package com.test.wjq.data;

import java.util.Arrays;

/**
 * 石头中珠宝数量
 */
public class NumJewelsInStones {


    public static void main(String[] args) {
        System.out.println((int)'A');
        //numJewelsInStones("z","ZZ");


        System.out.println(Math.log10(90));

    }


    public static int numJewelsInStones(String J, String S) {
        int[] charArr = new int[58];
        Arrays.fill(charArr,0);
        for (int i = 0; i <S.length();i++){
           char c = S.charAt(i);
            charArr[c - 'A'] += 1;
        }
        int k = 0;
        for (int i = 0 ; i < J.length(); i++ ){
            char c = J.charAt(i);
            k += charArr[c - 'A'];
        }
        return k;
    }

}
