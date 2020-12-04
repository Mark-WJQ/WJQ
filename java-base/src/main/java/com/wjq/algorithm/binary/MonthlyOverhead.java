package com.wjq.algorithm.binary;

/**
 *
 * 描述
 * 农夫约翰是一个精明的会计师。他意识到自己可能没有足够的钱来维持农场的运转了。他计算出并记录下了接下来 N (1 ≤ N ≤ 100,000) 天里每天需要的开销。
 *
 * 约翰打算为连续的M (1 ≤ M ≤ N) 个财政周期创建预算案，他把一个财政周期命名为fajo月。每个fajo月包含一天或连续的多天，每天被恰好包含在一个fajo月里。
 *
 * 约翰的目标是合理安排每个fajo月包含的天数，使得开销最多的fajo月的开销尽可能少。
 *
 *
 *
 * 输入
 * 第一行包含两个整数N,M，用单个空格隔开。
 * 接下来N行，每行包含一个1到10000之间的整数，按顺序给出接下来N天里每天的开销。
 * 输出
 * 一个整数，即最大月度开销的最小值。
 * 样例输入
 * 7 5
 * 100
 * 400
 * 300
 * 100
 * 500
 * 101
 * 400
 * 样例输出
 * 500
 * 提示
 * 若约翰将前两天作为一个月，第三、四两天作为一个月，最后三天每天作为一个月，则最
 *
 *
 *  解题思路
 *  求出总预算 T，由于 (1 ≤ M ≤ N) 所以可以认为一个fajo月的预算最大可以为 T
 *  l=0,r=T,b = (l+r)/2
 *  通过对预算T的二分求出满足条件的预算 b
 *
 *  组装出满足 M 个财政周期的且每个财政周期的金额 <=b
 *  每个财政周期包含的天数 >=1
 *
 *  如果组装出的财政周期数 <= M,则 r = b-1
 *  如果组装过程中一个财政周期的预算不满足一天的额度或m>M，则 l = b+1
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/2
 */
public class MonthlyOverhead {

	public static void main(String[] args) {
		MonthlyOverhead overhead = new MonthlyOverhead();
		System.out.println(overhead.overhead());
	}


	int overhead() {
		//总额度
		int t = 0;
		for (int i =0;i<N;i++){
			t+= f[i];
		}

		int l = 0;
		int r = t;
		int result = -1;
		while (l<=r){
			int b = (l+r)/2;
			if (fit(b)){
				r = b -1;
				result = b;
			}else {
				l = b+1;
			}
		}
		return result;
	}

	/**
	 * 天数
	 */
	int N = 7;
	/**
	 * 财政周期数
	 */
	int M = 5;
	/**
	 * 每天的预算
	 */
	int f[] = new int[]{100,400,300,100,500,101,400};

	boolean fit(int b) {
		int t = 0;
		int m = 1;
		for (int i = 0; i < N; i++) {
			//额度太少
			if (f[i] > b) {
				return false;
			}
			t += f[i];
			if (t <= b) {
				continue;
			}
			else {
				++m;
				t = f[i];

			}
		}
		//说明分配给每个财政周期的额度过大，需要减少分配额度
		if (m <= M) {
			return true;
		}
		return false;

	}

}
