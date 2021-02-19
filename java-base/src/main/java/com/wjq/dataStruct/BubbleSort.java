package com.wjq.dataStruct;

import java.util.Arrays;

/**
 * 冒泡排序,两两比较相邻元素
 *
 * Created by wangjianqiang on 2019/5/10.
 */
public class BubbleSort {



    public void simpleSort(int k[]){
        int n = k.length;

        for (int i = 0;i < n; i++){
            for (int j = i+1;j < n;j++){
                if (k[i] > k[j]){
                    //交换
                    int temp = k[i];
                    k[i] = k[j];
                    k[j] = temp;
                }
            }
        }
    }



    public static void sort(int k[]){
        //flag 的作用，冒泡排序的特性决定了，在某一轮比较重如果未发生未知交换则说明后面的数据都是有序的
        int n = k.length,flag = 1;
        for (int i = 0;i< n && flag == 1 ;i++){
            flag = 0;
            for (int j = n -1; j > i ; j--){
                if (k[j] < k[j-1]){
                    //交换
                    int temp = k[j];
                    k[j] = k[j-1];
                    k[j-1] = temp;
                    flag = 1;
                }
            }
        }


    }


    public static void main(String[] args) {
        int k[] = {1,5,3,4};
        sort(k);
        for (int i = 0;i< k.length;i++) {
            System.out.print(k[i] + ",");
        }
    }






}
