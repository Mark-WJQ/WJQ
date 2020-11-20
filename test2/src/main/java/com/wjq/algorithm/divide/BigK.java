package com.wjq.algorithm.divide;

/**
 *输出前K大的数字
 *
 * 给定一个数组，统计前K大的数，并且把这k个数从大到小输出。
 *
 * 输入
 * 第一行包含一个整数n，表示数组的大小。n < 100000。
 * 第二行包含n个整数，表示数组的元素，整数之间以一个空格分开。每个整数的绝对值不超过100000000。
 * 第三行包含一个整数k。k < n。
 * 输出
 * 从大到小输出前k大的数，每个数一行。
 * 样例输入
 * 10
 * 4 5 6 9 8 7 1 2 3 0
 * 5
 * 样例输出
 * 9
 * 8
 * 7
 * 6
 * 5
 *
 * 解题思路
 * 结合快排的思想
 * 在数组中 对于a[0],可以分别出 大于或小于 a[0] 的数组
 * 如果 大于a[0] 的 个数 >k 则再对大于数组做取前k大数字
 * 否则从 小于a[0] 的数组再取 k->a[0] 个数
 *
 * f(a[0],start,end,k)
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/4
 */
public class BigK {

	public static void main(String[] args) {
		int a[] = new int[]{4,5,6,9,8,7,1,2,3,0};
		f(a,0,a.length-1,5);
		for (int i = 0;i < 5;i++){
			System.out.println(a[a.length-1-i]);
		}
	}


	static void f(int[] a, int start, int end, int k) {

		if (start < end) {
			int base = a[start];
			int i = start;
			int j = end;
			while (i < j) {
				while (a[j]>base && i<j){
					j--;
				}

				if (i < j)
					a[i++] = a[j];
				while (a[i] <= base && i<j){
					i++;
				}
				if (i < j)
					a[j--] = a[i];
			}
			a[i] = base;
			if (end - i >= k) {
				f(a, i+1, end, k);
			}
			else {
				f(a, start, i, k - (end - i));
				f(a,i+1,end,end-i);
			}

		}

	}

}
