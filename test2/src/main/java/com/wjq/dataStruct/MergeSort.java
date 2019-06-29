package com.wjq.dataStruct;

public class MergeSort {


    public static void sort(int[] a,int start,int end){

        if (end - start > 1) {
            int i = start;

            int middle = (start + end) / 2;
            int j = middle + 1;
            sort(a, start, middle);
            sort(a,middle+1,end);

            //分开排完后，合并排序挤过

            //使用插入排序试试


            for (int k = j;k<=end;k++){
                int temp = a[k];
                int y;
                for (y = k-1; y>=start && a[y] > temp;y--){
                    a[y+1] = a[y];
                }
                a[y+1] = temp;
            }





            /*int[] k = new int[end - start +1];
            int x = 0;
            while (i <= middle && j <= end){

                if (a[i] < a[j]){
                    k[x++] = a[i++];
                }else {
                    k[x++] = a[j++];
                }
            }
            while (i <= middle){
                k[x++] = a[i++];
            }
            while (j <= end){
                k[x++] = a[j++];
            }
            for (i = 0;i< x;i++){
                a[i+ start] = k[i];
            }*/

        }else {

            if (a[start] > a[end]) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{9,8,7,6,5,4};
        sort(a,0,a.length-1);
        for (int i : a){
            System.out.println(i);
        }
    }
}
