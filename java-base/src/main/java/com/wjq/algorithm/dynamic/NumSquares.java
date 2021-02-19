package com.wjq.algorithm.dynamic;

/**
 *
 * @author wangjianqiang24
 * @date 2021/2/8
 */
public class NumSquares {


	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

	public static int numSquares(int n) {
		if (n == 0 || n == 1){
			return n;
		}
		int[] r = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int k = i*i;
			if (k > n){
				break;
			}
			r[k] = 1;
		}

		int last = 1;
		for (int i = 2; i <= n ; i++) {
			if (r[i] == 1){
				last = i;
				continue;
			}
			r[i] = r[i - last] + 1;
			for (int j = 1; j <= i ; j++) {
				if (j*j == last){
					break;
				}
				r[i] = Math.min(r[i-j*j]+1,r[i]);
			}
		}
		return r[n];

	}

}
