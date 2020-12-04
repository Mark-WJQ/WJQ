package com.wjq.algorithm.dynamic;

/**
 *
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 *
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 *
 * 示例:
 * 输入:
 * A = [9,1,2,3,9]
 * K = 3
 * 输出: 20
 * 解释:
 * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 A 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 说明:
 *
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * 答案误差在 10^-6 内被视为是正确的。
 *
 * @author wangjianqiang24
 * @date 2020/11/10
 */
public class MaxAvgSum {


	public static void main(String[] args) {
		MaxAvgSum avgSum = new MaxAvgSum();
		//System.out.println(avgSum.sum(3,0,5));

		System.out.println(avgSum.f(3,avgSum.nums));

		System.out.println(avgSum.fv1(3,avgSum.nums));
	}




	int[] nums = new int[]{9,1,2,3,9};

	double[][] r;

	/**
	 *
	 *  长度为m的数组最多可以分为 m 个子数组
	 *  所以
	 *  假设最后一个分组的位置为 i   k-1 <= i <= m-1,即i后边为最后一个分组，最后一个数组包含位置i的数字
	 *
	 * @param k  分为k个 相邻的非空子数组
	 * @param s  数组分割起始位置
	 * @param e  数组分割结束位置 +1
	 * @return
	 */
	double sum(int k, int s, int e) {
		if(r[k][e] != 0){
			return r[k][e];
		}
		double result = 0;
		for (int i = k-1; i < e - s ; i++) {
			result = Math.max(sum(k - 1, s, i) + avg(nums, i , e), result);
		}
		return r[k][e] = result;
	}





	/**
	 * 对给定数组求平均数
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	double avg(int[] A, int s, int e) {
		double sum = 0;
		for (int i = s; i < e; i++) {
			sum += A[i];
		}
		return sum / (e - s);
	}


	/**
	 * 分解问题，确定状态
	 * 我们假定数组的前i个元素，可以分为 k 个非空子序列， 0 <k <=i
	 * 则有表示 dp(k,i)
	 *
	 * 初始状态
	 * 当k=1 时，dp(1,i) = 前i个元素的平均值
	 *
	 * 状态转移
	 * 对于 dp(k,i) = Max{dp(k-1,j)+avg(j,i)}  k-1 < j < i（j表示元素个数，k表示分组数，j >= k,不然会分出空组）
	 * dp(k-1,j)+avg(j,i),减少一个分组，并且是最多前i-1个元素，再加上第j到i的元素的平均数
	 * dp(k-1,j) 就是前j个元素分k-1组的最大值，可以复用
	 * @param k
	 * @param a
	 * @return
	 */
	double f(int k,int[] a){
		int m = a.length;
		double[][] r = new double[k+1][m+1];

		for (int i = 1; i <= m; i++) {
			r[1][i] = avg(a,0,i);
		}

		double[] p = new double[m];
		p[0] = a[0];
		for (int i = 1; i < m; i++) {
			p[i] = a[i] + p[i-1];
		}

		for (int i = 2; i <=k ; i++) {
			for (int j = i; j <=m ; j++) {
				for (int l = i-1; l < j; l++) {
					r[i][j] = Math.max(r[i][j],r[i-1][l] + (p[j-1] - p[l-1])/(j-l));
				}

			}
		}

		return r[k][m];
	}


	/**
	 * 从上述解法中可以看到第k行的数据，只与k-1行有关系，所以我们可以考虑数组复用，减少空间复杂度
	 *
	 * @param k
	 * @param a
	 * @return
	 */
	double fv1(int k,int[] a){
		int m = a.length;
		double[] r = new double[m+1];

		for (int i = 1; i <= m; i++) {
			r[i] = avg(a,0,i);
		}

		double[] p = new double[m];
		p[0] = a[0];
		for (int i = 1; i < m; i++) {
			p[i] = a[i] + p[i-1];
		}

		for (int i = 2; i <=k ; i++) {
			//从后向前算，不然会覆盖数据
			for (int j = m; j >=i ; j--) {
				for (int l = i-1; l < j; l++) {
					r[j] = Math.max(r[j],r[l] + (p[j-1] - p[l-1])/(j-l));
				}

			}
		}

		return r[m];
	}
}
