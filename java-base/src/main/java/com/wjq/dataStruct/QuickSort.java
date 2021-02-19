package com.wjq.dataStruct;

/**
 * 快速排序
 */
public class QuickSort {


    public static void sort(int[] a,int start,int end){

        if (end <= start ){
            return;
        }

        int poviot = poviot(a,start,end);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[j] > poviot) {
                j--;
            }
            if (i < j && j > start) {
                a[i++] = a[j];
            }

            while (i < j && a[i] < poviot) {
                i++;
            }
            if (i < j && i < end)
                a[j--] = a[i];
        }
        a[i] = poviot;

        System.out.println(i);

        sort(a,start,i -1);
        sort(a,i + 1,end);
    }

    public static int poviot(int a[] ,int start,int end){

        int middle = (start + end) /2;

        if (a[middle] < a[start]){
            swep(a,start,middle);
        }
        if (a[start] > a[end]){
            swep(a,start,end);
        }
        if (a[middle] > a[end]){
            swep(a,middle,end);
        }

        swep(a,middle,end);


        return a[end];
    }




    public static void quickSort(int[] a,int start,int end){

        if (end <= start ){
            return;
        }
        int pivot = poviot(a,start,end);
        int i = start,j = end -1;
        for (;;){
            while (a[++i] < pivot){
            }
            while (a[--j] >pivot){}
            if (i < j){
                swep(a,i,j);
            }else {
                break;
            }
        }
        swep(a,i,end-1);
        quickSort(a,start,i-1);
        quickSort(a,i+1,end);



    }


    public static void swep(int[] a,int start,int end){
        int item = a[start];
        a[start] = a[end];
        a[end] = item;
    }

    public static void main(String[] args) {

        int[] a = new int[]{5,4,3,6,7,2,1,9};

        //sort(a,0,a.length-1);

        quickSort(a,0,a.length-1);
        for (int b : a){
            System.out.print(b);
        }

    }





}
