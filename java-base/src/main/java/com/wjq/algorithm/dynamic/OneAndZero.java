package com.wjq.algorithm.dynamic;

/**
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * @author wangjianqiang24
 * @date 2020/11/10
 */
public class OneAndZero {


	public static void main(String[] args) {
		OneAndZero oneAndZero = new OneAndZero();
		System.out.println(oneAndZero.findMax(5,3));



	}



	String[] strs = new String[] {"10", "0001", "111001", "1", "0"};
	int findMax(int m,int n){
		int[][] dp = new int[m+1][n+1];
		for (String str:strs){
			int ones = 0;
			int zeos = 0;
			for (int i = 0; i <str.length() ; i++) {
				int count = str.charAt(i) == '0'? zeos++ : ones++;
			}
			for (int i = m; i >= zeos; i--) {
				for (int j = n; j >= ones ; j--) {
					dp[i][j] = Math.max(dp[i-zeos][j-ones]+1,dp[i][j]);
				}

			}
		}
		return dp[m][n];

	}
}
