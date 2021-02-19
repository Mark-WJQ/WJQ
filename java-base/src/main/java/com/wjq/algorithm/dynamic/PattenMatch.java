package com.wjq.algorithm.dynamic;


//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/16
 */
public class PattenMatch {


	public static void main(String[] args) {
		PattenMatch p = new PattenMatch();
		System.out.println(p.isMatch("aaba", "ab*a*c*a"));
	}


	/**
	 * 分解问题
	 * 被匹配串s,长度为sl,下标表示为i
	 * 模式串p，长度为pl，下标表示为j
	 * 则问题可以转化为r(i,j),即长度为i的字符串与长度为j的模式串是否匹配,当r(i,j) = 1 时，我们可以求r(i+1,j+1),r(i+1,j),r(i,j-1)(j-1为*，对前面的字符是重复),r(i,j-2)(当前模式字符为*，则往前推两个字符可以认为没有新增字符)
	 * 此时状态可以确定r(i,j)
	 * 初始状态是r(0,0) = 1
	 * 状态转移公式参考分解
	 *
	 *
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return true;
		}

		if (".*".equals(p)) {
			return true;
		}

		if (s == null || p == null) {
			return false;
		}

		int sl = s.length();
		int pl = p.length();
		char[] scs =  s.toCharArray();
		char[] pcs = p.toCharArray();
		int[][] result = new int[sl + 1][pl + 1];
		int[] r1 = result[0];
		//s 与 p 都为空也是匹配的
		r1[0] = 1;
		//空串的匹配度，空串与*相关
		for (int i = 0; i < pl; i++) {
			char pc = pcs[i];
			if (pc == '*') {
				if (r1[i - 1] == 1) {
					r1[i + 1] = 1;
				}
			}
		}


		for (int i = 1; i <= sl; i++) {
			for (int j = 1; j <= pl; j++) {
				char pc = pcs[j - 1];
				char sc = scs[i-1];
				if ( pc == '*' && (  result[i][j-2] == 1 || result[i][j - 1] == 1)) {
					result[i][j] = 1;
					continue;
				}

				//r(i-1,j-1) 匹配
				if (result[i - 1][j - 1] == 1) {
					//匹配任意字符 或两个字符相等
					if (pc == '.' || pc == sc) {
						result[i][j] = 1;
						continue;
					}
					//匹配 0个或 n个前字符
					if (pc == '*' && result[i][j-1] ==1) {
						result[i][j] = 1;
						continue;
					}

				}

				//如果串s[0,i-2] 与 p[0,j],即 r(i-1,j) == 1,那么当pc==*时，r(i,j-1) == 1 那么就可以匹配
				if (result[i-1][j] == 1 && pc == '*' && j > 1 && (sc ==pcs[j-2] || '.' == pcs[j-2])){
					result[i][j] = 1;
					continue;
				}

			}
		}
		return result[sl][pl] == 1 ? true : false;
	}


}
