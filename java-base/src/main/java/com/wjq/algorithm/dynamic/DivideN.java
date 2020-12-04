package com.wjq.algorithm.dynamic;

/**
 *
 * @author wangjianqiang24
 * @date 2020/11/13
 */
public class DivideN {


	int f(int n, int base) {
		int count = 1;
		for (int i = base ; i <= n / 2; i++) {
			if (2 * i == n) {
				continue;
			}
			count += f(n - i, i+1);

		}
		return count;

	}


	public static void main(String[] args) {

		DivideN n = new DivideN();
		System.out.println(n.f(6, 1));
		System.out.println(n.f1(6, 1));

	}


	/**
	 * 以base 为起点 n 最多可以分成多少份
	 * 状态为f(n,base)  0 <base <=n
	 * 初始状态为 f(n,n) = 1
	 * 状态转移 f(i,j) = 累加 f(i-k,k+1)  j < k <= i/2
	 *
	 * 先分割k
	 * f(i,j) = f(i-k,k+1) j <= k <i
	 *
	 * @param n
	 * @param base
	 * @return
	 */
	int f1(int n, int base) {
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = j; k <= i/2 ; k++) {
					if (k == i - k) {
						continue;
					}
					dp[i][j] += dp[i - k][k + 1];
					dp[i][j] += 1;
				}
			}
		}
		return dp[n][base];

	}

}
