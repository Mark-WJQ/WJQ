package com.wjq.algorithm.dynamic;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [['0']]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [['1']]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [['0','0']]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/30
 */
public class MaximalRectangle {

	public static void main(String[] args) {
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		char[][] matrix = new char[][] {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		//matrix = new char[][] {{'1', '0', '0', '0', '1'}, {'1', '1', '0', '1', '1'}, {'1', '1', '1', '1', '1'}};
		matrix = new char[][]{{'0','0','0','0','0','0','1'},{'0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1'},{'0','0','0','1','1','1','1'}};
		System.out.println(maximalRectangle.maximalRectangle(matrix));
	}


	/**
	 * 定义类
	 * class Pos{
	 *     int s;  面积
	 *     int l;   长
	 *     int w;  宽
	 * }
	 *
	 *  分解问题，可以将拆分为小矩阵，知道矩阵的只剩一个元素
	 * 假设 r[i][j] 表示以matrix[i][j] 为右下角节点的最大矩形
	 * 假设matrix[i][j] = 1
	 * 则有以下几种情况
	 * r[i-1][j-1]==0  则 r[i][j] = Math.max(r[i-1][j],r[i][j-1])+1
	 * r[i-1][j] == 0 || r[i][j-1] == 0  则 r[i][j].l = Math.max(r[i - 1][j].l, r[i][j - 1].l) + 1; w = Math.max(r[i - 1][j].w, r[i][j - 1].w) + 1;
	 * 剩余便是三面都不为空说明他们是可以连在一起的
	 * 可以求出公共的面积
	 * l = Math.min(r[i-1][j-1].l,r[i-1][j].l)
	 * w = Math.min(r[i-1][j-1].w,r[i][j-1].w);
	 * r[i][j].s = (l+1)*(w+1)
	 *
	 * 初始状态
	 * r[0][0] = 0;
	 *
	 *
	 *
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		int max = 0;
		int rows = matrix.length;
		if (rows == 0) {
			return max;
		}
		int cols = matrix[0].length;
		if (cols == 0) {
			return max;
		}
		P[][] r = new P[rows + 1][cols + 1];
		P nu = new P(0, 0, 0);

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i == 1) {
					r[i - 1][j] = nu;
					if (j == 1) {
						r[i - 1][j - 1] = nu;
					}
				}
				if (j == 1) {
					r[i][j - 1] = nu;
				}
				if (matrix[i - 1][j - 1] == '1') {
					int l = 0;
					int w = 0;
					//宽
					w = r[i][j - 1].w + 1;
					//长
					l = r[i - 1][j].l + 1;
					if (w > l) {
						l = 1;
					}
					else {
						w = 1;
					}
					if (r[i - 1][j].s != 0 && r[i][j - 1].s != 0) {
						int ml = Math.min(r[i - 1][j - 1].l, r[i - 1][j].l) + 1;
						int mw = Math.min(r[i - 1][j - 1].w, r[i][j - 1].w) + 1;
						if (ml * mw > w * l) {
							w = mw;
							l = ml;
						}
					}
					
					r[i][j] = new P(l * w, l, w);
					max = Math.max(r[i][j].s, max);
				}
				else {
					r[i][j] = nu;
				}
			}
		}
		return max;

	}


	public static class P {

		public P(int s, int l, int w) {
			this.s = s;
			this.l = l;
			this.w = w;
		}

		int s;
		int l;
		int w;
	}
}
