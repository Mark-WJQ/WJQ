package com.wjq.algorithm.map;

/**
 *
 * 生日蛋糕
 * 要制作一个体积为Nπ的M层蛋糕，每层都是一个圆柱体。
 * 设从下往上数第i(1 <= i <= M) 层蛋糕是半径为Ri，高度为Hi的圆柱体。当i<M时，要求Ri > Ri+1且 Hi>Hi+1.
 * 由于要在蛋糕上抹奶油，为尽可能节约经费，我们希望蛋糕外表面（最下层的下底面除外）的面积Q最小。
 * 令Q=Sπ
 * 请编程对给出的N和M，找出蛋糕的制作方案（适当的Ri和Hi的值），使最小。
 * 除Q外，以上数据皆为正整数
 *
 * 输入
 * 有两行，第一行为N（N <= 10000），表示待制做的蛋糕的体积为Nπ；第二行为M(M <= 20)，表示蛋糕的层数为M。
 * 输出
 * 仅一行，是一个正整数S（若无解则S = 0）
 *
 *
 * 样例输入
 * 100
 * 2
 * 样例输出
 * 68
 *
 * 解题思路
 * 深度优先搜索，枚举什么
 *  枚举每一层可能的高度和半径
 * 如何确定搜索范围
 *  底层蛋糕的最大可能半径和最大可能高度
 * 搜索顺序，哪些地方体现搜索顺序？
 *  从底层往上大蛋糕，而不是从顶层往下搭
 * 如何剪枝？
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/19
 */
public class BirthdayCake {

	/**
	 * 体积
	 */
	int N;
	/**
	 * 层数
	 */
	int M;


	public BirthdayCake(int n, int m) {
		N = n;
		M = m;
	}

	public static void main(String[] args) {
		BirthdayCake cake = new BirthdayCake(1000, 5);
		cake.make();
		System.out.println(cake.minS);
	}


	int s;

	int minS = Integer.MAX_VALUE;


	int[] leastV;   //最小体积
	int[] leastA;  // 最小面积
	int[] maxV;    //最大体积

	int[][] minArea;

	void make() {
		leastV = new int[M + 1];
		leastA = new int[M + 1];
		//最底层最多剩下多大的蛋糕，因为当i<M时，要求Ri > Ri+1且 Hi>Hi+1.所以最上一层的最小半径为1，最小高为1，以此类推
		for (int i = 1; i < M; i++) {
			leastV[i] = i * i * i + leastV[i - 1];
			leastA[i] = 2*i*i + leastA[i-1];

		}
		//求最大直径与高 v = r^2 * h
		int lastV = N - leastV[M - 1];
		int maxH = lastV;
		int maxR = (int) Math.sqrt(lastV);
		minArea = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				minArea[i][j] = Integer.MAX_VALUE;
			}
		}

		make(N, M, maxR, maxH);
	}

	/**
	 * 做蛋糕
	 * @param n  蛋糕体积
	 * @param m  蛋糕层数
	 * @param maxR  蛋糕最大半径，把所有体积都给一层，并且高度为1，最大半径就求出来了
	 * @param maxH  蛋糕最大高度，同求最大半径，将半径设为1
	 * @return
	 */
	void make(int n, int m, int maxR, int maxH) {
		if (n < 0 || m < 0) {
			return;
		}

		if (m == 0 || n == 0) {
			//没有剩余体积跟层数说明刚刚好
			if (n == m) {
				minS = Math.min(s, minS);
			}
			return;
		}

		//高度或半径无法安排层级
		if (maxH < m || maxH < m){
			return;
		}

		// 最小体积都大于剩余体积，结束吧,可行性剪枝
		if (leastV[m] > n) {
			return;
		}

		//搭建中的面积大于已经求出的最小面积，走
		if (s > minS){
			return;
		}

		//搭建中的面积加上可能最小面积比已经求出的最下面积大，不符合条件
		if ((s + leastA[m] > minS)){
			return;
		}

		//还没搭建的那些成最大体积也到不了缺口
		int leftV = 0;
		for (int i = 0; i < m; i++) {
			leftV += (maxR-i)*(maxR-i)*(maxH-i);
		}
		if (leftV < n){
			return;
		}


		//消耗相同的体积跟层数后，做出来面积大的就可以撤了，最优性剪枝
		/*if (minArea[n][m] < s){
			return;
		}*/
		minArea[n][m] = s;
		for (int i = maxR; i > 0; i--) {
			for (int j = maxH; j > 0; j--) {
				if (m == M) {
					s = i * i;
				}
				s += 2 * i * j;
				make(n - i * i * j, m - 1, i - 1, j - 1);
				s -= 2 * i * j;
			}
		}

	}
}
