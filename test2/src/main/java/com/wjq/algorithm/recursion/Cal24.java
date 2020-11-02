package com.wjq.algorithm.recursion;

/**
 *
 * 算24
 * 给出四个小于10的正整数，你可以使用加减乘除4种运算以及括号把这4个数连接起来得到一个表达式。
 * 现在的问题是，是否存在一种方式使得得到的表达式的结果等于24.
 * 这里加减乘除以及括号的运算结果和运算的优先级跟我们平常的定义一致（这里除法定义是实数除法）。
 *
 * 比如，对于5,5,5,1,我们知道5*（5-1/5）由此可以得到24.
 * 又比如，对于1，1，4，2 我们怎么样也得不到24.
 *
 * 输入
 * 输入数据包括多行，每行给出一组测试数据，包括4个小于10的正整数。最后一组测试数据中包括4个0，这组数据不用处理。
 *
 * 输出
 * 对于每一组测试数据，输出一行，如果可以得到24，输出YES，否则输出 NO
 * 样例输入
 * 5 5 5 1
 * 1 1 4 2
 * 样例输出
 * YES
 * NO
 *
 * 问题分解，第一步我要做什么，做完第一步，剩下的是什么，第一步先拿两个数计算
 *
 *
 * n个数算24，必有两个数要先算。这两个数算的结果，和剩余n-2个数，就构成了n-1个数求24的问题。
 *
 * 枚举先算的两个数，以及这两个数的运算方式。
 *
 * 边界条件
 * 最终剩下一个数是否等于24
 * 注意浮点数比较是否相等，不能用 ==
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/10/26
 */
public class Cal24 {


	public static void main(String[] args) {


		double[] a = new double[]{4,0,6,0};
		Cal24 cal24 = new Cal24();

		System.out.println(cal24.cal24(a,4));
	}


	/**
	 *  对数组a进行24计算
	 * @param a 计算数组
	 * @param n 数组中包含几个元素
	 * @return
	 */
	public boolean cal24(double[] a,int n) {
		if (n == 1) {
			if (a[0] - 24 == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double next[] = new double[4];
				int m = 0;
				for (int k = 0; k < n; k++) {
					if (k != i && k != j) {
						next[m++] = a[k];
					}
				}
				double r = a[i] + a[j];
				next[m] = r;
				if (cal24(next, m + 1)) {
					return true;
				}
				r = a[i] - a[j];
				next[m] = r;
				if (cal24(next, m + 1)) {
					return true;
				}
				r = a[j] - a[i];
				next[m] = r;
				if (cal24(next, m + 1)) {
					return true;
				}
				r = a[i] * a[j];
				next[m] = r;
				if (cal24(next, m + 1)) {
					return true;
				}
				if (a[j] != 0) {
					r = a[i] / a[j];
					next[m] = r;
					if (cal24(next, m + 1)) {
						return true;
					}
				}

				if (a[i] != 0) {
					r = a[j] / a[i];
					next[m] = r;
					if (cal24(next, m + 1)) {
						return true;
					}
				}

			}

		}

		return false;

	}

}
