package com.wjq.collection;


/**
 * Created by wangjianqiang on 2019/1/6.\
 *
 * 快速排序：找到基准点，分治（将小于基准的数字置于左边，大于的值置于右边），递归分治
 *
 *
 */
public class QuckSort {

    public static void main(String[] args) {
        int[] array = new int[]{19,3,15,8,34,26,17,21,4,20};
        //sort(array);
        sort(0,array.length-1,array);

        //paration(array,0,array.length-1);
        for (int i = 0;i < array.length;i ++)
            System.out.println(array[i]);
    }

    private static void sort(int l,int h,int[] array) {
        if (l >= h)
            return;
        int mid = paration(array,l,h);
        //做低位处理
        sort(l,mid-1,array);
        //做高位处理
        sort(mid + 1,h,array);

    }





    private static int paration(int[] array, int low, int high) {
        if (low >= high)
            return low;
        //低位
        int i = low;
        //高位
        int j = high;
        //基准数
        int x = array[low];
        //循环处理
        while (i < j){
            //先将基准数字跟高位数字比较，如果小于基准数字则将array[j] 赋予低位空位，若不小于则 j-- 继续向前
            while (x < array[j] && i < j){
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            //高位替换以后再比较低位处理
            while (x >= array[i] && i < j){
                i ++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }

        }
        //将基准值放入中间位置，低位
        array[i] = x;
        return i;

    }


}
