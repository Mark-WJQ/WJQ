package com.wjq.algorithm.recursion;

/**
 * 用递归将问题分解为规模更小的子问题进行求解
 *
 * 树老师爬楼梯，他可以每次走1级或2级，输入楼梯的级数。求不同的走法数。
 *
 * 例如：
 * 楼梯一共有3级，他可以每次都走1级或者第一次走1级，第二次走2级
 * 也可以第一次走2级，第二次走1级，一共3种方法。
 *
 * 输入
 * 输入包含若干行，每行包含一个正整数N，代表楼梯级数，1 <= N <= 30 输出不同的走发书，每一行输入对应一行
 *
 * 输出
 * 不同的走法数，每一行输入对应一行输出
 *
 *
 * 样例输入
 * 5
 * 8
 * 10
 * 样例输出
 * 8
 * 34
 * 89
 *
 * @author wangjianqiang24
 * @date 2020/10/23
 */
public class Stair {


	/**
	 * 注意这里是在求走法不是 走了多少步，所以第一步有两种走法 走1级 或走两级
	 * n级台阶的走法
	 * 先走1级后，n-1级台阶的走法 + 先走2级后，n-2级台阶的走法
	 * f(n)= f(n-1) + f(n-2)
	 *
	 * 边界条件
	 * n < 0  0,n = 0  1
	 * n= 0 1,n=1 1
	 * n=1 1,n=2 2
	 * @param args
	 */
	public static void main(String[] args) {

		Stair stair = new Stair();
		System.out.println(stair.step(8));
	}





	int step(int n){
		if (n == 1 || n== 2){
			return n;
		}
		return step(n-1) + step(n-2);
	}



}
