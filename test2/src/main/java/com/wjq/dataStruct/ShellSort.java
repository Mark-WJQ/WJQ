package com.wjq.dataStruct;

/**
 * 希尔排序
 * Created by wangjianqiang on 2019/5/15.
 */
public class ShellSort {


    public static void sort(int[] a) {
        int n = a.length, temp, gap = n, j, i;
        do {
            gap = gap / 3 + 1 ;
            for (i = gap; i < n; i++) {
                if (a[i] < a[i - gap]) {
                    temp = a[i];
                    for (j = i - gap; j >=0 && a[j] > temp; j = j - gap) {
                        a[j + gap] = a[j];
                    }
                    a[j + gap] = temp;
                }
            }
        } while (gap > 1);


        for (i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
    }


    public static void main(String[] args) {
        sort(new int[]{8, 5, 2,6, 7, 3, 9});
    }

}
