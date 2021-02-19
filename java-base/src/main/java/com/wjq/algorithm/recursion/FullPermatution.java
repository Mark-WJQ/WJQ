package com.wjq.algorithm.recursion;

/**
 * 全排列
 * 给定一个由不同的小写字母组成的字符集，输出这个字符串的所有全排列。
 * 我们假设对于小写字母有'a'<'b'<……<'y'<'z',而且给定的字符串中的字母已经按照从小到大的顺序排序。
 *
 *
 * 输入
 * 输入只有一行，是一个由不同小写字母组成的字符串，一直字符串的长度在1到6之间。
 * 输出
 * 输出这个字符串的所有排列方式，每行一个排列，要求字母序比较小的排列在前面。
 * 字母序如下定义：
 * 已知S=S1S2……Sk,T=T1T2……Tk,则S<T等价于，存在p(1<=p<=k),使得s1=t1,s2=t2，……，Sp-1=Tp-1,Sp<tp成立。
 *
 *解题思路
 * 首先确定该题使用递归求解。
 * 递归求解的步骤
 * 一是分解问题
 * 二是确定边界值
 * 首先大序列的全排列是 一个字母 + 剩余字母的全排列
 * 边界条件是当一个字母进行全排列是 只有它本身
 * 所以我们通过遍历字符串，全排列剩余的字符
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/10/28
 */
public class FullPermatution {


	public static void main(String[] args) {
		FullPermatution permatution = new FullPermatution();
		permatution.N = 3;
		String[]  rs = permatution.per("abcde");
		System.out.println(rs.length);
		for (int i = 0;i< rs.length;i++){
			System.out.println(rs[i]);
		}

	}

	int N;




	String[] per(String str){
		int l = str.length();
		if (l == 1){
			return new String[]{str};
		}
		String r = null;
		int len = 1;
		for (int i = 1;i<=l;i++){
			len *= i;
		}
		String[] strs = new String[len];
		int k = 0;
		for (int i =0;i < l;i++){
			String indx = String.valueOf(str.charAt(i));
			String[] rs;
			if (i == 0){
				rs = per(str.substring(1));
			}else {
				rs = per(str.substring(0,i).concat(i == l-1 ? "":str.substring(i+1)));
			}
			for (int j = 0;j< rs.length;j++){
				strs[k++] = indx + rs[j];
			}
		}
		return strs;
	}

}
