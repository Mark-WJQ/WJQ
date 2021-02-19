package com.wjq.algorithm.dynamic;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/4
 */
public class Huiwen {

	public String longestPalindrome(String s) {
		int l = s.length();
		int[][] result = new int[l][l];
		for (int i = 0; i < l; i++) {
			result[i][i] = 1;
		}
		int start = 0;
		int end = 0;
		for (int i = l - 2; i >= 0; i--) {
			for (int j = l-1; j > i; j--) {
				//连续两个字符
				//中间的回文,判断回文时只与前一个节点相关，所以可以优化成只用一行
				if ((j - i == 1 || result[i + 1][j - 1] == 1) && s.charAt(i) == s.charAt(j)) {
					result[i][j] = 1;
					if (j -i > end -start){
						start = i;
						end = j;
					}
				}
			}
		}
		return s.subSequence(start,end+1).toString();

	}


	/**
	 * 分解问题
	 *  对于求最大回文串，就是求s[i]-s[j]（i<= j < s.length） 是回文串，然后找出其中最长,一个字符是回文，连续两个字符如果是相等的话也是回文，一个回文串长度 >2的话，掐头去尾后还是一个回文串
	 *  根据以上描述可以得出
	 *  状态可以表示为 dp(i,j)
	 *  初始状态dp(i,j) = 1 （ i== j）
	 *  状态转移方程为
	 *  dp(i,j) = 	nums[i] == num[j] && (j-i == 1)
	 *  			dp(i+1,j-1) && nums[i] == num[j] (j > i)
	 *
	 *  转移方程中判断只与 i+1 行 有关，所以可以检结果用一维数组表示
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindromeV1(String s) {
		int l = s.length();
		//结果数组的初始状态就是 i==j的结果
		int[] result = new int[l];
		result[l-1] = 1;
		int start = 0;
		int end = 0;
		for (int i = l - 2; i >= 0; i--) {
			for (int j = l-1; j >= i; j--) {
				//连续两个字符，或同一个字符
				//中间的回文,判断回文时只与前一个节点相关，所以可以优化成只用一行
				if ((j - i <= 1 || result[j - 1] == 1) && s.charAt(i) == s.charAt(j)) {
					result[j] = 1;
					if (j -i > end -start){
						start = i;
						end = j;
					}
				}else {
					//如果不是回文串需要重置，不然会影响后续的处理
					result[j] = 0;
				}
			}
		}
		return s.subSequence(start,end+1).toString();

	}

	public static void main(String[] args) {
		System.out.println(2<<1);
		System.out.println(Math.abs((long)-2147483648));
	}
}
