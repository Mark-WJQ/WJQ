package com.wjq.dataStruct;

/**
 * 八皇后问题回溯算法
 *
 */
public class WolfQueen {


    int max = 8;
    /**
     * 存放下标表示所在行数值表示所在列数
     */
    int array[] = new int[max];


    public static void main(String[] args) {
        new WolfQueen().check(0);
    }

    /**
     * 检查第 n 行的元素
     * 假设前 n-1行已经排列完，开始排第n行
     * @param n
     */
    private void check(int n) {
        //如果检查位数 n 与 最大皇后数相等，增表示全部通过可以输出
        if (n == max) {
            print();
            return;
        }

        //对于第 n 行的 每个点都进行检查看是否满足皇后条件
        for (int j = 0; j < max; j++) {
            if (judge(n,j)) {
                array[n] = j;
                //前 n 行元素已经排列好，继续排 第 n+1 行的数据
                check(n + 1);
            }
        }
    }

    /**
     * 判断是否满足横，竖，对角线
     *
     * 在对角线上的两个元素  abs(行差) == abs(列差)
     * 当前检查行 n 与以前的已经排列好的行作比较，查看是否在同一列
     * 当前检查点位（n,i） 与 (array[i],j) 作比较，查看是否在对角线上
     * @param n 第 n 行
     * @param j 当前检查第 j 列
     * @return
     */
    private boolean judge(int n,int j) {
        for (int i = 0; i < n; i++) {
            if (array[i] == j || (Math.abs(n - i) == Math.abs( array[i] -j))) {
                return false;
            }
        }
        return true;
    }



    private void print(){
        for(int i = 0;i < array.length; i++){
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println();
    }


}
