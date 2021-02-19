package com.wjq.dataStruct;


/**
 * 有n级台阶，每次只能跨1，2，3步阶，问有多少种跨法
 *
 */
public class Factorial {


    /**
     * 通过归纳总结：
     *  n = 3x + 2y + z
     *  当 n = 1 时，有 1 种跨法 (0,0,1)
     *  当 n = 2 时，有 2 种跨法 (0,1,0),(0,0,2)
     *  当 n = 3 时，有 4 种跨法 (1,0,0),先跨一阶 n= n-1 =2 有两种跨法，先跨两阶 n= n-2 =1 还有一种跨法
     *  当 n = 4 时，先跨一阶 n = n-1 = 3 有四种 ，先跨 2阶 n = n - 2 = 2 有 2 种跨法， 先跨3 阶 n= n -3 = 1,还有 1种跨法 所以 f(4) = 4 + 2 + 1
     *  以此类推 f(n) = f(n-1) + f(n-2) + f(n-3)
     *
     *  递归解法，空间复杂度高
     * @param k
     * @return
     */
    public static int f(int k){
        if (k <= 0){
            return 0;
        }

        if (k == 1 || k == 2){
            return k;
        }

        if (k == 3){
            return 4;
        }

        return f(k-1) + f(k -2) + f(k-3);

    }


    /**
     * 非递归解法
     * 空间复杂度为O(1)
     * @param k
     */
    public static int f1(int k){

        int arr[] = {1,1,2};
        int index = -1;
        if (k < 0 ){
            return 0;
        }

        if (k ==0 || k == 1 || k == 2){
            return arr[k];
        }

        //计数计算过多少次，相当于倒数计算，只跟k-2次有关，k是多大并无关系
        while (k-- >2){
            index ++;

            index %= 3;

            arr[index] = arr[0] + arr[1] + arr[2];
        }
        return arr[index];
    }


    public static void main(String[] args) {

        System.out.println(f1(5));
        System.out.println(f(5));
    }



}
