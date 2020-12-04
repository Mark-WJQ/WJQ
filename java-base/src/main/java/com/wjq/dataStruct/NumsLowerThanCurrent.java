package com.wjq.dataStruct;

import java.util.Arrays;

public class NumsLowerThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int l = nums.length;
        int[] a = new int[l];
        Arrays.fill(a,0);
        for (int i = 0 ; i< l; i++){
            for (int j = 0; j < l; j++){
                if (nums[i] > nums[j]){
                    a[i] ++;
                }
            }
        }
        return a;
    }




    public static int[] v1(int[] nums){

        int l = nums.length;
        int[] a = new int[l];
        Arrays.fill(a,0);
        for (int i = 0 ; i< l; i++){
            for (int j =i; j < l; j++){
                if(i == j){
                    continue;
                }
                if (nums[i] > nums[j]){
                    a[i] ++;
                }else if (nums[i] < nums[j]){
                    a[j] ++;
                }
            }
        }
        return a;
    }




    public static int[] v2(int[] nums){
        int[] a = new int[100];
        int l = nums.length;
        for (int i = 0;i < l ;i ++){





        }


        return nums;

    }



    public static void main(String[] args) {

        smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
    }


}
