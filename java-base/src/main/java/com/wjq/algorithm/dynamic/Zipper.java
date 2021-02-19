package com.wjq.algorithm.dynamic;

/**
 *
 * 描述
 * Given three strings, you are to determine whether the third string can be formed by combining the characters in the first two strings. The first two strings can be mixed arbitrarily, but each must stay in its original order.
 *
 * For example, consider forming "tcraete" from "cat" and "tree":
 *
 * String A: cat
 * String B: tree
 * String C: tcraete
 *
 * As you can see, we can form the third string by alternating characters from the two strings. As a second example, consider forming "catrtee" from "cat" and "tree":
 *
 * String A: cat
 * String B: tree
 * String C: catrtee
 *
 * Finally, notice that it is impossible to form "cttaree" from "cat" and "tree".
 * 输入
 * The first line of input contains a single positive integer from 1 through 1000. It represents the number of data sets to follow. The processing for each data set is identical. The data sets appear on the following lines, one data set per line.
 *
 * For each data set, the line of input consists of three strings, separated by a single space. All strings are composed of upper and lower case letters only. The length of the third string is always the sum of the lengths of the first two strings. The first two strings will have lengths between 1 and 200 characters, inclusive.
 * 输出
 * For each data set, print:
 *
 * Data set n: yes
 *
 * if the third string can be formed from the first two, or
 *
 * Data set n: no
 *
 * if it cannot. Of course n should be replaced by the data set number. See the sample output below for an example.
 * 样例输入
 * 3
 * cat tree tcraete
 * cat tree catrtee
 * cat tree cttaree
 * 样例输出
 * Data set 1: yes
 * Data set 2: yes
 * Data set 3: no
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/9
 */
public class Zipper {


	public static void main(String[] args) {
		Zipper zipper = new Zipper(2, 3);
		System.out.println(zipper.r(-1, -1));
		System.out.println(zipper.match(2,3,6));
		System.out.println(zipper.d(3,4));

	}


	public Zipper(int x, int y) {
		this.x = x;
		this.y = y;
		c = new char[] { 't', 'c', 'r', 'a', 'e', 't', 'e'};
		//c = new char[] { 'c', 't', 't', 'a', 'r', 'e', 'e'};
		a = new char[] { 'c', 'a', 't'};
		b = new char[] { 't', 'r', 'e', 'e'};
	}

	int x;
	int y;
	char[] c = new char[3];
	char[] a = new char[2];
	char[] b = new char[1];

	boolean r(int i, int j) {

		if (i == x && j == y) {
			return true;
		}

		int k = i + j + 1;
		if (i + 1 <= x && c[k + 1] == a[i + 1]) {
			if (r(i + 1, j)) {
				return true;
			}
		}
		if (j + 1 <= y && c[k + 1] == b[j + 1])
			if (r(i, j + 1)) {
				return true;
			}

		return false;
	}


	class Index {
		int i;
		int j;
	}

	int K;

	String[] strings = new String[3];

	/**
	 * 分解问题
	 * 有 A,B,C 三个字符串  长度分别为 x,y,z
	 *
	 * 当字符长C 的长度为k时，A ,B 串的长度分别为 i,j
	 * 则可以分析出 该题的状态为 i(0 <=i <=x),j(0<=j<=y),k(0<=k<=z)
	 * 边界条件
	 * 通过分析，当A,B,C 完全匹配时，状态是固定的，即 match(x,y,z)
	 * 当最后一个位置确定时，便可知道C中最后一个符是从哪里获取的，我们便可知道下一个字符应该从哪个位置获取
	 *
	 * 状态状态转移
	 *  if(a[i] != b[j]){
	 *      if(a[i] == c[k]){
	 *          i--;
	 *          k--;
	 *      }else if (b[j] == c[k]) {
	 * 			j--;
	 * 			k--;
	 *      }else {
	 * 			return false;
	 *      }
	 *  }
	 *
	 *
	 *
	 *
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	boolean match(int i, int j, int k) {
		while (i >= 0 && j >= 0) {
			if (a[i] != b[j]) {
				if (a[i] == c[k]) {
					i--;
					k--;
				}
				else if (b[j] == c[k]) {
					j--;
					k--;
				}else {
					return false;
				}
			}
			else {
				if (match(i - 1, j, k - 1) || match(i, j - 1, k - 1)) {
					return true;
				}
				return false;
			}
		}

		while (i >= 0) {
			if (c[k] != a[i]) {
				return false;
			}
			else {
				i--; k--;
			}
		}
		while (j >= 0) {
			if (c[k] != b[j]) {
				return false;
			}
			else {
				j--; k--;
			}
		}

		return true;
	}


	/**
	 * 比较重要的一点是由已知推未知，将求出来的结果进行保存变为已知，不过有一些缺点是有的结果并不需要求解
	 * @param x
	 * @param y
	 * @return
	 */
	boolean d(int x,int y){
		boolean[][] dp = new boolean[x+1][y+1];
		dp[0][0] = true;
		for (int i =0;i<=x;i++){
			for (int j = 0; j <= y; j++) {
				if (i > 0) {
					if (dp[i-1][j] && a[i-1] == c[i+j-1])
						dp[i][j] = true;
				}
				if (j >0){
					if (dp[i][j-1] && b[j-1] == c[i+j-1]){
						dp[i][j] = true;
					}
				}
			}
		}
		return dp[x][y];
	}


}
