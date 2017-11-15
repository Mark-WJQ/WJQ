package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/8.
 * <p>
 * 吸血鬼数字
 */
public class Vampire {


    public static void main(String[] args) {


        for (int i = 1000; i < 10000; i++) {
            if (i % 100 == 0)
                continue;

            String v = String.valueOf(i);
            int k = v.length();

            if (k % 2 != 0)
                continue;

            String[] vs = v.split("");
            /*int m = k/2;
            for (int n = 0;n < m;n ++){

            }*/



            for (int m = 0 ;m < k; m ++  ){
                for (int n = 0; n < k ; n++){
                    if (m == n){
                        continue;
                    }
                    //System.out.println(m + "_" + n);
                   String s = vs[m] + vs[n];
                    int x = k-m;
                    int y = k -n;
                    if (m == 0){
                        x = k/2;
                    }
                    if (m * 2 == k)
                        x = 0;
                    if (n == 0 )
                        y = k/2;
                    if (n*2 == k)
                        y = k/2;


                    String s1 = vs[x] + vs[y];
                    String s2 = vs[y] + vs[x];
                   // System.out.println(s + "-" + s1 +"-" + s2);
                    if (Integer.valueOf(s) * Integer.valueOf(s1) == i){
                        System.out.println("s1:" +i + "=" + s + "*" + s1);
                    }

                    if (Integer.valueOf(s) * Integer.valueOf(s2) == i){
                        System.out.println("s2:" + i + "=" + s + "*" + s2);
                    }
                }

            }


        }


    }
}
