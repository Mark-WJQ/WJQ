package com.wjq.algorithm.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * N个城市，编号1到N。城市间有R条单向道路。每条道路连接两个城市，有长度和过路费两个属性。Bob只有K块钱，
 * 他想从城市1走到N。问最短共需要走多长的路。如果到不了N，则输出-1.
 * 2  <= N <= 100
 * 0 <= K <= 10000
 * 1<= R <= 10000
 * 每条路的长度L,1 <= L <= 100
 * 每条路的过路费T，0 <= T <= 100
 *
 * 输入
 * K
 * N
 * R
 * s1e1L1T1
 * s1e2L2T2
 * ……
 * sReRLRTR
 * se是路起点和终点
 *
 *
 * 解题思路
 * 从城市1开始深度优先遍历整个图，找到所有能够到达N的走法，选一个最优的
 *
 *
 * 样例输入
 * 5
 * 6
 * 7
 * 1 2 2 3
 * 2 4 3 3
 * 3 4 2 4
 * 1 3 4 1
 * 4 6 2 1
 * 3 5 2 0
 * 5 4 3 2
 * 样例输出
 *
 * 11
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/19
 */
public class Roads {

	/**
	 * 总钱数
	 */
	int K;
	/**
	 * 城市数量
	 */
	int N;
	/**
	 * 道路数量
	 */
	int R;

	/**
	 * 最短道路
	 */
	int minL = Integer.MAX_VALUE;

	/**
	 * 当前已走路程
	 */
	int l;

	/**
	 * 当前已花费
	 */
	int t;

	static class Rode {
		/**
		 * 终点位置
		 */
		int e;
		/**
		 * 距离
		 */
		int l;
		/**
		 * 费用
		 */
		int t;

		public Rode(int e, int l, int t) {
			this.e = e;
			this.l = l;
			this.t = t;
		}
	}


	/**
	 * 道路枚举
	 */
	List<Rode>[] rodes;

	/**
	 * 是否访问过
	 */
	int[] visited;

	/**
	 * 相同城市相同金额的最短路程
	 */
	int[][] minLen;


	/**
	 *
	 * @param n  从哪个城市开始走
	 * @param t  还剩下多少钱
	 */
	void arrive(Rode n, int t) {
		if (t < 0) {
			//没钱，走不动了
			return;
		}
		if (n.e == N) {
			//走到㡳了
			minL = Math.min(l, minL);
			return;
		}
		//已经走过了
		if (visited[n.e] == 1) {
			return;
		}

		//相同终点，相同剩余金额，已经走过的大于最优的就回吧，没用，可行性剪枝
		if (minLen[n.e][t] < l) {
			return;
		}

		minLen[n.e][t] = l;

		List<Rode> list = rodes[n.e];
		visited[n.e] = 1;
		for (Rode r : list) {
			//增加里程
			l += r.l;
			//减少剩余钱数
			t -= r.t;
			arrive(r, t);
			t += r.t;
			l -= r.l;
		}
		visited[n.e] = 0;
	}


	void init() {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		int index = 0;
		while (scanner.hasNext()) {
			if (index == 0) {
				this.K = scanner.nextInt();
			}
			else if (index == 1) {
				this.N = scanner.nextInt();
				visited = new int[this.N+1];
				rodes = new List[this.N+1];
				minLen = new int[this.N+1][this.K+1];
			}
			else if (index == 2) {
				this.R = scanner.nextInt();
			}
			else {
				String s = scanner.next();
				String[] ss = s.split(" ");
				int sta = Integer.valueOf(ss[0]);

				List<Rode> list = rodes[sta];
				if (Objects.isNull(list)) {
					list = new ArrayList<>();
					rodes[sta] = list;
				}
				list.add(new Rode(Integer.valueOf(ss[1]), Integer.valueOf(ss[2]), Integer.valueOf(ss[3])));
				if (index == this.R + 2) {
					break;
				}
			}
			index++;
		}
		scanner.close();

		for (int i = 0; i < this.N; i++) {
			for (int j = 1; j <= this.K; j++) {
				minLen[i][j] = Integer.MAX_VALUE;
			}
		}
	}


	public static void main(String[] args) {
		Roads roads = new Roads();
		roads.init();
		roads.arrive(new Rode(1,0,0),roads.K);
		System.out.println(roads.minL);
	}

}
