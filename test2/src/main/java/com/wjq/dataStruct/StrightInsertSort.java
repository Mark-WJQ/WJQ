package com.wjq.dataStruct;

/**
 *
 * 插入排序,相当于在一个有序队列末尾插入，并且与前面的数据比较
 *
 * Created by wangjianqiang on 2019/5/14.
 */
public class StrightInsertSort {


    public static void sort(int[] array){
        int l = array.length,j;

        for (int i = 1;i< l;i++){
            if (array[i] < array[i-1]){

                int temp = array[i];
                for (j = i - 1;j >= 0 && temp < array[j] ;j--){
                        array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
        for (int i : array){
            System.out.println(i);
        }


    }


    public static void main(String[] args) {
        sort(new int[]{8,5,2,7,3,9});
    }
}
