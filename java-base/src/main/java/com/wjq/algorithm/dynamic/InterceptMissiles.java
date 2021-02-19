package com.wjq.algorithm.dynamic;

import java.util.Arrays;

/**
 * 拦截导弹
 *
 *  描述
 * 某国为了防御敌国的导弹袭击，开发出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭，并观测到导弹依次飞来的高度，请计算这套系统最多能拦截多少导弹。拦截来袭导弹时，必须按来袭导弹袭击的时间顺序，不允许先拦截后面的导弹，再拦截前面的导弹。
 * 输入
 * 输入有两行，
 * 第一行，输入雷达捕捉到的敌国导弹的数量k（k<=25），
 * 第二行，输入k个正整数，表示k枚导弹的高度，按来袭导弹的袭击时间顺序给出，以空格分隔。
 * 输出
 * 输出只有一行，包含一个整数，表示最多能拦截多少枚导弹。
 * 样例输入
 * 8
 * 300 207 155 300 299 170 158 65
 * 样例输出
 * 6
 *
 * 问题实质上可以转化为最长下降子序列
 *
 * @author wangjianqiang24
 * @date 2020/11/6
 */
public class InterceptMissiles {


	int N;

	public InterceptMissiles(int n) {
		N = n;
		r = new int[n];

	}

	public static void main(String[] args) {
		int a[] = new int[] {100,300, 155,297, 300, 399, 170, 158, 65,400};
		InterceptMissiles missiles = new InterceptMissiles(a.length);
		System.out.println(missiles.f1(a, 0, a.length - 1));
		System.out.println(missiles.getMax(a));
		System.out.println(missiles.f2(a,0,a.length-1));

	}


	int getMax(int[] a) {
		Arrays.fill(r, -1);
		int result = -1;
		for (int i = 0; i < N-1; i++) {
			result = Math.max(f(a, i+1, a.length - 1, a[i]), result);
		}
		return result +1;

	}


	int r[];

	/**
	 * 假设从第i个导弹开始拦截，高度为a[i]
	 *
	 * @param a
	 * @param s
	 * @param e
	 * @param base
	 * @return
	 */
	int f(int[] a, int s, int e, int base) {
		/*if (r[s] != -1) {
			return r[s];
		}*/
		if (s == e) {
			if (a[s] > base) {
				return 0;
			}
			else {
				return 1;
			}
		}

		int result = 0;
		for (int i = s; i <e; i++) {
			int count = 0;
			if (a[i] > base) {
				count += f(a, i + 1, e, base);
			}
			else {
				count += f(a, i + 1, e, a[i]) + 1;
			}
			result = Math.max(result,count);
		}
		return result;

	}


	/**
	 *
	 * 错误
	 * 假设从第i个导弹开始拦截，高度为a[i]
	 *   因为导弹发射有时间顺序，那么从第i个导弹到最后一个导弹之间的最大下降序列是确定的，可以从最后一个导弹到达推到出
	 *   是[i+1，n] 中
	 *
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	int f1(int[] a, int s, int e) {
		int[] ad = new int[a.length];
		Arrays.fill(ad, 1);
		for (int i = e-1; i >= s; i--) {
			for (int j = e; j > i; j--) {
				if (a[j] <= a[i]) {
					ad[i] = Math.max(ad[i],ad[j]+1);
				}
			}
		}
		return ad[0];

	}


	/**
	 *1. 找子问题
	 * 求以 ak(k =1,2,3……N) 为终点的最长下降子序列的长度
	 * 一个下降子序列中最右边的那个数，称为该子序列的终点。
	 * 虽然这个子问题的和原问题的形式上并不完全一样，但只要这N个子问题都解决了，那么这N个子问题的解中，
	 * 最大的那个就是整个问题的解。
	 * 2 确定状态
	 * 子问题只和一个变量--数字的位置相关。因此序列中数的位置k就是状态，而状态k对应的值，就是以ak为终点的的最长下降子序列的长度。
	 * 状态一共有N个。
	 * 3 找出状态转移方程：
	 * maxLen(k)表示以ak作为终点的最长下降子序列的长度，那么：
	 * 初始状态： maxLen(1) = 1
	 * maxLen(k) = max{maxLen(i):0<=i<k 且 ai>=</k>ak 且 k != 0} + 1,若找不到这样的i，则maxLen(k) = 1 表示本身
	 * mxLen(k) 的值，就是在ak的左边，终点数值小于ak，且长度最大的那个下降子序列长度再加1,。因为ak左边任何终点小于ak的子序列，加上ak后就能
	 * 形成一个更长的下降子序列。
	 *
	 * 时间复杂度 O(N^2)
	 *
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	int f2(int[] a,int s,int e){
		int[] result = new int[a.length];
		//初始化结果
		Arrays.fill(result,1);
		int r = 0;
		for (int i = s+1; i <=e; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] >= a[i]){
					result[i] = Math.max(result[i],result[j]+1);
				}
			}
			r = Math.max(r,result[i]);
		}
		return r;
	}
}
