package com.wjq.algorithm.dynamic;

//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//
//
// 两个字符串完全匹配才算匹配成功。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
//
//
// 示例 3:
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//
// 示例 4:
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//
//
// 示例 5:
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false

import java.util.Arrays;

import org.springframework.util.Assert;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/29
 */
public class WildCard {


	public static void main(String[] args) {
		WildCard w = new WildCard();
		/*Assert.isTrue(w.isMatch("", "******"));
		Assert.isTrue(w.isMatch("adceb", "*a*b"));
		Assert.isTrue(w.isMatch("a", "*a*"));
		Assert.isTrue(!w.isMatch("aab", "c*a*b"));*/
		Assert.isTrue(!w.isMatch("acdcb", "a*c?b"));
		Assert.isTrue(w.isMatch("adceb", "a*b"));
		Assert.isTrue(!w.isMatch("aa", "a"));
		Assert.isTrue(w.isMatch("", ""));
	}


	/**
	 * 分解问题
	 * 可以将字符串s与模式串p的匹配，分解为s子串与p子串的匹配
	 *
	 * 假设 i 为模式串的索引，j为字符串的索引
	 * 则可得r(i,j) 为 模式子串pi与字符子串sj的匹配结果
	 *
	 * 可以得出初始状态 r(0,0) = 1;
	 *
	 * 当r(i,j) = 1 时
	 *  可以推断出
	 *  if(p[i] == '*'){
	 *      r(i,j+1) = 1;
	 *  }else{
	 *      if(p[i+1] == '?' || p[i+1] == s[j+1] || p[i+1] == '*'){
	 *          r(i+1,j+1) = 1;
	 *      }
	 *  }
	 *
	 * 所以当我们要求r(i,j)时
	 * 需要
	 * r(i,j-1) = 1
	 * r(i-1,j-1) = 1
	 *
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if ("*".equals(p) || s.equals(p)) {
			return true;
		}
		int sl = s.length();
		int pl = p.length();
		int[][] r = new int[pl + 1][sl + 1];
		r[0][0] = 1;
		int[][] result = new int[2][sl+1];
		result[0][0] = 1;
		for (int i = 1; i <= pl; i++) {
			char pc = p.charAt(i - 1);
			for (int j = 0; j <= sl; j++) {
				result[1][j] = 0;
				if (pc == '*' && (result[0][j] == 1 || (j > 0 &&result[1][j - 1] == 1))) {
					result[1][j] = 1;
					continue;
				}
				if (j > 0) {
					char sc = s.charAt(j - 1);
					if (result[0][j - 1] == 1 && ('?' == pc || pc == sc || pc == '*')) {
						 result[1][j] = 1;
					}
				}

				/*if (pc == '*' && (r[i - 1][j] == 1 || (j > 0 &&r[i][j - 1] == 1))) {
					r[i][j] = 1;
					continue;
				}
				if (j > 0) {
					char sc = s.charAt(j - 1);
					if (r[i - 1][j - 1] == 1 && ('?' == pc || pc == sc || pc == '*')) {
						r[i][j] = 1;
					}
				}*/
			}
			result[0] = Arrays.copyOf(result[1],sl+1);
		}

		//return r[pl][sl] == 1;
		return result[1][sl] == 1;
	}
}
