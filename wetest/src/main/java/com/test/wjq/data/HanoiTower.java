package com.test.wjq.data;



public class HanoiTower {

    /**
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
