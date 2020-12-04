package com.wjq.algorithm.dynamic;

import java.util.Arrays;

/**
 *
 * 描述
 * 给定n个1到9的数字，要求在数字之间摆放m个加号(加号两边必须有数字），使得所得到的加法表达式的值最小，并输出该值。例如，在1234中摆放1个加号，最好的摆法就是12+34,和为36
 *
 * 输入
 * 有不超过15组数据
 * 每组数据两行。第一行是整数m，表示有m个加号要放( 0<=m<=50)
 * 第二行是若干个数字。数字总数n不超过50,且 m <= n-1
 * 输出
 * 对每组数据，输出最小加法表达式的值
 * 样例输入
 * 2
 * 123456
 * 1
 * 123456
 * 4
 * 12345
 * 样例输出
 * 102
 * 579
 * 15
 * 提示
 * 要用到高精度计算，即用数组来存放long long 都装不下的大整数，并用模拟列竖式的办法进行大整数的加法。
 *
 * @author wangjianqiang24
 * @date 2020/11/9
 */
public class BestPlus {


	public static void main(String[] args) {
		BestPlus plus = new BestPlus(2);
		System.out.println(plus.plus(plus.m,plus.ns.length));
		System.out.println(plus.plusv1(plus.m,plus.ns));
		System.out.println(plus.plusv2(plus.m,plus.ns));


	}

	public BestPlus(int m) {
		this.m = m;
		ns = new int[]{1,2,3,4,5,6};
		r = new long[m+1][ns.length+1];
		for (int i = 0; i <=m ; i++) {
			Arrays.fill(r[i],-1);

		}
	}

	int m;
	int[] ns;

	long[][] r ;

	/**
	 * 问题分解
	 * 假设最右边放置的+在位置i后边
	 * 则剩余的问题便是 在0-i 中放置m-1个+，求最小值
	 *
	 * 状态表达 m,n
	 *
	 * 边界条件
	 * m = 0 ,剩余数字
	 *
	 * 状态转换
	 * min(m,n) = Min(min(m-1,i),Num(i,n));  Num为剩余数字十进制
	 *
	 *
	 * @param m  m个加号
	 * @param n  n个数字
	 * @return
	 */
	long plus(int m, int n) {
		if (r[m][n] != -1){
			return r[m][n];
		}
		if (m == 0) {
			return nums(0, n);
		}
		long result = Long.MAX_VALUE;
		// + 的数量需要大于剩余数字的，不然+会摆放不下 i 最小为m
		for (int i = m-1; i < n-1 ; i++) {
			result = Math.min(result,plus(m - 1, i+1) + nums(i+1, n));
		}
		return r[m][n] = result;

	}




	long nums(int s, int n) {
		long result = 0;
		for (int i = s; i < n; i++) {
			result = result * 10 + ns[i];
		}
		return result;
	}


	/**
	 * 状态
	 * dp(m,n)  加号个数，数组个数  0<=m<=n-1 ,n个数字最多只能有n-1个+
	 *
	 * 初始状态
	 * dp(0,n) 数组中每个数的累加值
	 *
	 * 状态转移
	 * dp(m,n) = Min(dp(m-1,j) + sum(j,n))    m < j < n
	 *
	 * @param m  加号个数
	 * @param nums  被操作数组
	 * @return
	 */
	long plusv1(int m,int[] nums){
		int n = nums.length;
		long[][] dp = new long[m+1][n+1];

		long[] p = new long[n];
		p[0] = nums[0];
		for (int i = 1; i < n; i++) {
			p[i] = p[i-1]*10+nums[i];
		}
		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i],Long.MAX_VALUE);
		}

		for (int i = 1; i <=n ; i++) {
			dp[0][i] = p[i-1];
		}
		//加号数量
		for (int i = 1; i <= m; i++) {
			//数字个数
			for (int j = i+1; j <= n; j++) {
				//m-1个加号时最大数字
				for (int k = i+1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j],dp[i-1][k] +nums(k,j));
				}
			}
		}
		return dp[m][n];

	}


	/**
	 * 空间优化，复用结果存储
	 * @param m
	 * @param nums
	 * @return
	 */
	long plusv2(int m,int[] nums){
		int n = nums.length;
		long[] dp = new long[n+1];

		long[] p = new long[n];
		p[0] = nums[0];
		for (int i = 1; i < n; i++) {
			p[i] = p[i-1]*10+nums[i];
		}

		for (int i = 1; i <=n ; i++) {
			dp[i] = p[i-1];
		}
		//加号数量
		for (int i = 1; i <= m; i++) {
			//数字个数
			for (int j = n; j > i; j--) {
				//m-1个加号时最大数字
				for (int k = i+1; k < j; k++) {
					dp[j] = Math.min(dp[j],dp[k] +nums(k,j));
				}
			}
		}
		return dp[n];

	}









}
