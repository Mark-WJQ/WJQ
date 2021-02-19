package com.wjq.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangjianqiang on 2017/12/18.
 */
public class TDArray {


    public static void main(String[] args) {
        //System.out.println(new Random());

        System.out.println(Arrays.deepToString(generic(3,3,1.0,10.3)));
        System.out.println(Arrays.deepToString(generic(2,3,4,3,19)));


        System.out.println(Arrays.deepToString(new double[1][2]));


           // CountingGenerator.test(CountingGenerator.class);


        System.out.println((byte)1990);

    }


    public static double[][] generic(int a,int b,double c,double d){
        double e[][] = new double[a][b];
        double increment = (d-c)/(a*b);
        double val = c;
        for (int i = 0;i< a ; i ++){
            for (int j = 0 ; j < b ; j++){
                e[i][j] = val;
                val = val + increment;
            }
        }
        return e;
    }


    public static double[][][] generic(int a,int b,int f,double c,double d){
        double e[][][] = new double[a][b][f];
        double increment = (d-c)/(a*b*f);
        double val = c;
        for (int i = 0;i< a ; i ++){
            for (int j = 0 ; j < b ; j++) {
                for (int k = 0; k < f; k++) {
                    e[i][j][k] = val;
                    val = val + increment;
                }
            }
        }
        return e;
    }


}
