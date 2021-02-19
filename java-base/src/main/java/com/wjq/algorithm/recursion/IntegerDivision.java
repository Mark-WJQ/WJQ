package com.wjq.algorithm.recursion;

/**
 * 整数划分
 * 描述
 * 将正整数n 表示成一系列正整数之和，n=n1+n2+…+nk, 其中n1>=n2>=…>=nk>=1 ，k>=1 。
 * 正整数n 的这种表示称为正整数n 的划分。正整数n 的不同的划分个数称为正整数n 的划分数。
 *
 * 输入
 * 标准的输入包含若干组测试数据。每组测试数据是一个整数N(0 < N <= 50)。
 * 输出
 * 对于每组测试数据，输出N的划分数。
 * 样例输入
 * 5
 * 样例输出
 * 7
 * 提示
 * 5, 4+1, 3+2, 3+1+1, 2+2+1, 2+1+1+1, 1+1+1+1+1
 *
 *
 * 解题思路
 * 1. 确定使用递归解法
 * 由 n1>=n2>=…>=nk>=1，假设此时分解至 nk-1,nk,那在接下来的分解中只需要关注 分解nk-1的序列中没有小于nk的正整数，且有序减小
 * 每次分解时只对 漪汾街序列中的第一个数字进行分解，对后续数字分解会造成重复计算
 * eg:
 *  5 可以分解为
 *  4,1  3,1,1
 *  3,2
 *  以上可以看出 在3,2 中如果对2 进行分解3,1,1，虽然分解后符合规则，但是跟4,1分解后的方式重复,所以只需3,2中的3 按要求继续分解即可
 *
 * 2. 分解问题，问题可以分解为 f(n) = Σf(n-i,i) (0 <i <= n/2)
 * 3  边界值 n=1 时只有一种分解法 return 1
 * @author wangjianqiang24
 * @date 2020/10/30
 */
public class IntegerDivision {


	public static void main(String[] args) {
		IntegerDivision division = new IntegerDivision();
		System.out.println(division.f(2,1));
	}

	/**
	 *
	 * @param n  被分解的数 nk
	 * @param base  相当于 n(k+1)是一个基准校验值，即由nk分解出来的值必须小于base
	 * @return
	 */
	int f(int n, int base) {
		if (n == 1)
			return 1;
		//n 本身就代表一种排列方式，所以初始化为1
		int result = 1;
		//遍历是为保证有序
		for (int i = 1; i <= n / 2; i++) {
			if (i >= base) {
				result += f(n - i, i);
			}
		}
		return result;
	}
}
