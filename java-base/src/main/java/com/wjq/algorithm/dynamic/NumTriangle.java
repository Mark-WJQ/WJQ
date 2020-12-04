package com.wjq.algorithm.dynamic;

import java.util.Arrays;

/**
 * 数字三角形
 *      7
 *    3  8
 *  8  1  0
 *2  7   4  4
 4  5  2   6  5
 * 在上面你的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
 * 路径上的每一步都只能往左下或右下走。只需求出这个最大和即可，不必给出具体路径。
 * 三角形的行数大于1小于等于100，数字为0-99
 *
 * 输入格式
 * 5  //三角形行数。下面是三角形
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 要求输出最大和
 *
 * 可以使用二维数组来保存输入的三角形，从而使得左下变为正下
 * D(i,j)
 * 左下 D(i+1,j) ,右下D(i+1,j+1)
 * MaxSum(r,j): 从D(i,j)到底边的各条路径中，最佳路径的数字之和。
 * 问题：求MaxSum(1,1)
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/5
 */
public class NumTriangle {


	public static void main(String[] args) {
		NumTriangle triangle = new NumTriangle(5);
		//System.out.println(triangle.v3(0,0));
		//System.out.println(triangle.v2(0,0));
		//System.out.println(triangle.dynamic(0,0));
		System.out.println(triangle.v1(0,0));
		//System.out.println(triangle.recursion(0,0));
	}

	public NumTriangle(int n) {
		N = n;
		d = new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		r = new int[N][N];
		for (int k = 0; k < N; k++) {
			Arrays.fill(r[k], -1);
		}
	}

	int N;
	int d[][];

	/**
	 * 典型递归问题,自顶向下分解问题
	 * D(i,j)出发，下一步只能走D(i+1,j)或D(i+1,j+1).故对于N行的三角形
	 * if( i == N){
	 *     MaxSum(i,j) = D(i,j)
	 * }else{
	 *     MaxSum(i,j) = Max{MaxSum(i+1,j),MaxSum(i+1,j+1)}+D(i,j)
	 * }
	 *
	 *  在该解法中存在大量重复计算，复杂度为2^n
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	int recursion(int i, int j) {
		if (i == N - 1) {
			return d[i][j];
		}
		else {
			return Math.max(recursion(i + 1, j), recursion(i + 1, j + 1)) + d[i][j];
		}
	}


	/**
	 * 存放结果的数组
	 */
	int r[][];

	/**
	 * 动态规划 --记忆递归型
	 * 针对递归中的重复计算，我们可以通过把计算结果缓存起来，减少计算次数来降低时间复杂度
	 * 使用一个对等的二维数组将结果缓存起来，这样时间复杂度是O(n^2)
	 * @param i
	 * @param j
	 * @return
	 */
	int v1(int i, int j) {

		if (r[i][j] != -1) {
			return r[i][j];
		}
		else {
			if (i == N - 1) {
				return d[i][j];
			}
			else {
				return r[i][j] = Math.max(v1(i + 1, j), v1(i + 1, j + 1)) + d[i][j];
			}
		}
	}


	/**
	 * 进一步优化使用动态规划的方式计算
	 * 递归转成递推
	 *
	 * 已知当 i == N-1时，MaxSum(i,j) = D(i,j)
	 * 并且 MaxSum(i,j) = Max{MaxSum(i+1,j),MaxSum(i+1,j+1)} + D(i,j)
	 * 可以由㡳向上求出最终的最终的结果MaxSum(0,0)
	 * 由已知求未知
	 * @param i
	 * @param j
	 * @return
	 */
	int dynamic(int i, int j) {
		//首先初始化已知结果
		r[N - 1] = Arrays.copyOf(d[N - 1], N);
		for (int k = N - 2; k >= i; k--) {
			for (int l = 0; l <= k; l++) {
				r[k][l] = Math.max(r[k + 1][l], r[k + 1][l + 1]) + d[k][l];
			}
		}
		return r[i][j];
	}


	int re[] = new int[N];

	/**
	 * 对于动态规划改进版
	 * 由第一版可知结果求出来以后只用一次就不再使用，造成空间上的浪费，由于每行结果最多只有 N 个，所以我们可以
	 * 用一个 N 大小的数组来重复使用来存放结果
	 * 每次计算出结果来都按索引顺序存放
	 * @param i
	 * @param j
	 * @return
	 */
	int v2(int i, int j) {
		//初始化结果
		re = Arrays.copyOf(d[N - 1], N);
		for (int k = N - 2; k >= i; k--) {
			for (int l = 0; l <= k; l++) {
				re[l] = Math.max(re[l], re[l + 1]) + d[k][l];
			}
		}
		return re[j];
	}

	/**
	 * 我们再分析一下，原始数组中的数据在计算完成以后也不会再使用，我们可以复用原始数组
	 * 可以每次计算MaxSum(i,j) 后将数据保存至d[i][j] 中
	 * @param i
	 * @param j
	 * @return
	 */
	int v3(int i, int j) {
		for (int k = N - 2; k >= i; k--) {
			for (int l = 0; l <= k; l++) {
				d[k][l] = Math.max(d[k + 1][l], d[k + 1][l + 1]) + d[k][l];
			}
		}
		return d[i][j];
	}

}
