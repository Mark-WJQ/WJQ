package com.wjq.dataStruct;


/**
 *  问题分解
 *
 *
 *
 */
public class HanoiTower {

    /**
     * 问题分解
     * 可以先将 n-1 个盘子 从 x -> y
     * 再将剩余一个盘子从 x -> z
     * 再将 n-2 个盘子从 y  -> x
     * 将y中剩余的一个盘子移动到z
     * 循环调用
     *
     *
     *
     *  汉诺塔移动,从 x 借助 y 移动到 z
     * @param n  需要移动的盘子数量
     * @param x  代表 x 柱
     * @param y  代表 y 柱
     * @param z  代表 z 柱
     */
    public static void move (int n,char x ,char y,char z){
        if (n == 1) {
            System.out.format("%c -> %c", x, z);
            System.out.println();
        }
        else {
            move(n - 1, x, z, y);
            System.out.format("%c -> %c",x,z);
            System.out.println();
            move(n-1,y,x,z);
        }
    }


    public static void main(String[] args) {
        move(10,'X','Y','Z');
    }



}
