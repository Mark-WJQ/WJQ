package com.wjq.netty.reactor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName Main3.java
 * @createTime 2019年11月11日 08:50:00
 */
public class Main3 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inData = in.next();
        in.close();

        int m = Integer.parseInt(inData.split(",")[0]);
        int n = Integer.parseInt(inData.split(",")[1]);
        int[] all = new int[m];

        for(int i = 1;i<=m;i++){
            all[i-1] = i;
        }

        int left = m;
        int count = 0;

        while ( left != 1){
           for (int i = 0;i < m;i++){
               if (all[i] != -1){
                   count ++;
                   if (count == n){
                       all[i] = -1;
                       left --;
                       count = 0;
                   }
               }
           }
        }

        for (int i = 0;i< m;i++){
            if(all[i] != -1){
                System.out.println("left :" + all[i]);
            }
        }
    }




}
