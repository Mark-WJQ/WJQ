package com.wjq.algorithm.dynamic;

/**
 * 分蛋糕
 * 有一块矩形大蛋糕，长和宽分别是整数w,h。现要将其切成m块小蛋糕，每个小蛋糕都必须是矩形，且长和宽均为整数
 * 切蛋糕时，每次切一块蛋糕，将其分成两个矩形蛋糕。请计算：最后得到的m块小蛋糕中，最大的那块蛋糕的面积下限。
 *
 * 假设w=4,h=4,m=4,则下面的切法可使得其中最大蛋糕块的面积最小。
 * 2*2=4,2*2=4,2*2=4,2*2=4
 * 假设w=4,h=4,m=3
 * 2*3=6,2*2=4,2*3=6
 *
 * 输入
 * 共有多行，每行表示一个测试案例。每行是三个用空格分开的整数w,h,m,其中1<=w,h,m<=20,m<=w*h,
 * 当w=h=m=0时不需要处理，表示输入结束。
 * 输出
 * 每个测试案例的结果占一行，输出一个整数，表示最大蛋糕块的面积下限。
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/15
 */
public class CutCake {

	public static void main(String[] args) {

		CutCake cutCake = new CutCake();
		System.out.println(cutCake.cut(4, 4, 2));
		System.out.println(cutCake.cutv1(4, 4, 3));

	}


	/**
	 *
	 * 解题思路
	 * 有三个状态 w,h,m
	 * 边界条件
	 * w*h < m+1 无穷
	 * m=0  w*h
	 * 状态转移
	 * 第一刀有两种方式 横切或竖切
	 * 切完后会分成两块，长宽 分别不大于w,h
	 * 剩余 m-1刀
	 * 对左边一块切 k 刀
	 * 对右边一块切 m-1-k 刀
	 *
	 *
	 * @param w 宽
	 * @param h 高
	 * @param m 切m刀，分成M块需要切M-1刀
	 * @return
	 */
	int cut(int w, int h, int m) {
		if (w * h < m + 1) {
			return Integer.MAX_VALUE;
		}
		if (m == 0) {
			return w * h;
		}


		int result = Integer.MAX_VALUE;
		//竖着切找到最大的最小面积
		for (int i = 0; i < w; i++) {
			//左右切几刀
			for (int k = 0; k < m; k++) {
				//每次切完以后最大块的面积
				result = Math.min(result, Math.max(cut(i, h, k), cut(w - i, h, m - 1 - k)));
			}

		}
		//横着切找到最大的最小面积
		for (int i = 0; i < h; i++) {
			for (int k = 0; k < m; k++) {
				result = Math.min(result, Math.max(cut(w, i, k), cut(w, h - i, m - 1 - k)));
			}
		}
		return result;
	}


	/**
	 * 对于递归方法的改进，使用动态规划解决
	 *  状态为 d(m,w,h)
	 *  初始状态
	 *  w*h < m
	 *   d(1,w,h) = w*h
	 *  状态转移
	 *   d(m,w,h) = min{Max{d(k,w,j),d(m-k,w,h-j)},Max{d(k,i,h),d(m-k,w-i,h)}}  0< j < h, 0 < i < w , 0 <k <=m
	 * @param w 宽
	 * @param h 高
	 * @param m 切多少块
	 * @return
	 */
	int cutv1(int w, int h, int m) {
		int[][][] result = new int[m + 1][w + 1][h + 1];
		for (int i = 1; i <= w; i++) {
			for (int j = 1; j <= h; j++) {
				result[1][i][j] = i * j;
			}
		}

		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= w; j++) {
				for (int k = 1; k <= h; k++) {
					result[i][j][k] = Integer.MAX_VALUE;
					if (j * k < i) {
						continue;
					}
					//竖切
					for (int n = 1; n < j; n++) {
						//先切几块
						for (int l = 1; l < i; l++) {

							result[i][j][k] = Math
									.min(result[i][j][k], Math.max(result[l][n][k], result[i - l][j - n][k]));
						}
					}

					//横切
					for (int o = 1; o < k; o++) {
						//先切几块
						for (int l = 1; l < i; l++) {
							result[i][j][k] = Math
									.min(result[i][j][k], Math.max(result[l][j][o], result[i - l][j][k - o]));
						}
					}
				}

			}
		}


		return result[m][w][h];

	}
}
