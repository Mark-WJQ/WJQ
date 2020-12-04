package com.wjq.algorithm.dynamic;

/**
 *
 * 给出两个字符串，求出这样的一个最长的公共子序列的长度：
 * 子序中的每个字符都能在两个原串中找到，而且每个字符的先后顺序和原串中的先后顺序一致。
 *
 * Sample Input
 * 	abcfbc abfcab
 * 	programming contest
 * 	abcd mnp
 * Sample Output
 * 	4
 * 	2
 * 	0
 *
 * @author wangjianqiang24
 * @date 2020/11/9
 */
public class MaxLenCommonArr {


	public static void main(String[] args) {

	}


	int[] A;
	int[] B;


	/**
	 * 分解问题
	 *
	 * 两个字符串公共字符序列 包含 他们子串的公共子序列，所以可以先求小串在根据小串的结果推导大串的公共序列
	 *
	 * 状态
	 *  在i,j 上有确定的公共子序列长度
	 *
	 * 初始状态,当其中任意一个字符串长度为0是，公共序列的长度都为0
	 * maxlen(0,bl) = 0    0 <= bl <= B.length
	 * maxLen(al,0) = 0    0 <= al < A.length
	 *
	 * 状态转移
	 *  if(A[i-1] == B[j-1]){
	 *      maxlen(i-1,j-1)+1
	 *  }else{
	 *      Max(maxLen(i-1,j),maxLen(i,j-));
	 *  }
	 *
	 * 时间复杂度 O(m*n)
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	int maxLen(int i, int j) {
		int[][] max = new int[i + 1][j + 1];
		for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				if (A[k - 1] == B[l - 1]) {
					//因为两个相等，所以要去 坐标为k-1,l-1 的最长子序列和，即 A[0]--A[k-2]和B[0]--B[l-2] 的最长公共子序列，如果他们都加上一个相同的字符那就是A[k-1] == B[l-1]
					max[k][l] = max[k - 1][l - 1] + 1;
				}
				else {
					//如果不相等，max(k-1,l),max(k,l-1),max(k,l) 不会比两者都大且不会比任何一项小，
					//证明 假设max(k,l) < max(k,l-1),max(k,l) 比 max(k,l-1) 多包含一个数B[l-1]，不可能小,所以假设不成立，同理k-1
					//证明 结果比两者都大，max(k,l)比k-1 多一个字符A[k-1],比l-1多一个字符B[l-1],如果max(k,l) 比两者都大的话,多出来的字符只能在最后并且起作用的，只能是A[k-1] == B[l-1]
					max[k][l] = Math.max(max[k - 1][l], max[k][l - 1]);
				}
			}
		}
		return max[i][j];

	}

}
