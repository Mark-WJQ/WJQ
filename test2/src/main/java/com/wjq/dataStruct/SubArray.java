package com.wjq.dataStruct;

import java.util.Arrays;

/**
 * 最大子序列，动态规划
 *
 * @author wjq
 * @version 1.0.0
 * @ClassName SubArray.java
 * @createTime 2020年02月23日 21:06:00
 */
public class SubArray {


    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 4, 6, 9, 7, 8, 6, 3, 10, 16, 11, 13, 14, 17, 21, 19};
        System.out.println(maxLenth(arr.length, arr));

        System.out.println(maxLenthBack(arr.length, arr));

        System.out.println(maxLenthDp(arr.length, arr));

    }


    /**
     * 暴力解法
     *
     * @param n
     * @param arr
     * @return
     */
    public static int maxLenth(int n, int[] arr) {
        if (n == 1)
            return 1;
        int maxl = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            int a = arr[j];
            int max = Integer.MIN_VALUE;
            for (int i = j - 1; i >= 0; i--) {
                if (a < arr[i])
                    continue;
                int sub = maxLenth(i + 1, arr);
                if (sub == -1)
                    continue;
                max = Math.max(sub + 1, max);
                maxl = Math.max(max, maxl);
            }
        }
        return maxl == Integer.MIN_VALUE ? -1 : maxl;

    }


    /**
     * 备忘录
     *
     * @param n
     * @param arr
     * @return
     */
    public static int maxLenthBack(int n, int[] arr) {

        int[] counts = new int[arr.length];
        Arrays.fill(counts, Integer.MIN_VALUE);
        counts[0] = 1;

        return helper(arr.length, arr, counts);

    }


    public static int helper(int n, int[] arr, int[] counts) {

        if (n == 1)
            return 1;
        if (counts[n - 1] != Integer.MIN_VALUE) {
            // System.out.println(n - 1 + "----" + counts[n - 1]);
            return counts[n - 1];
        }
        int maxl = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            int a = arr[j];
            int max = Integer.MIN_VALUE;
            for (int i = j - 1; i >= 0; i--) {
                if (a < arr[i])
                    continue;
                int sub = helper(i + 1, arr, counts);
                if (sub == -1)
                    continue;
                max = Math.max(sub + 1, max);
                maxl = Math.max(max, maxl);
            }
            counts[j] = max;
        }
        return maxl == Integer.MIN_VALUE ? -1 : maxl;


    }


    /**
     * 动态规划
     * @param n
     * @param arr
     * @return
     */
    public static int maxLenthDp(int n, int[] arr) {

        int[] counts = new int[arr.length];
        Arrays.fill(counts, Integer.MIN_VALUE);
        counts[0] = 1;
        for (int i = 1; i < n; i++) {
            int sub = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    if (counts[j] > sub)
                        sub = counts[j];
                }
            }
            counts[i] = sub + 1;
        }

        return counts[n - 1];

    }


}
