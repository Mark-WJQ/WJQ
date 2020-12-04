package com.wjq.dataStruct;

/**
 *
 * 选择排序
 *
 * Created by wangjianqiang on 2019/5/14.
 */
public class SelectSort {


    /**
     * 记录最小值的的下标，选择完成后交换
     * @param array
     */
    public static void sort(int[] array){
        int l = array.length;
        for (int i = 0 ; i < l; i++){
            int min = i;
            for (int j = i + 1; j < l;j++){
                if (array[min] > array[j]){
                   min = j;
                }
            }
            if (min != i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        sort(new int[]{8,5,2,7,3,9});
    }

}
