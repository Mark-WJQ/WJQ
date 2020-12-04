package com.wjq.algorithm.map;

/**
 *
 * 已知一张地图（以而二维矩阵的形式表示）以及佐助和鸣人的位置。地图上的每个位置都可以走到，只不过有些位置上有大蛇丸的手下，
 * 需要先打败大蛇丸的手下才能到这些位置。鸣人有一定数量的查克拉，每一个单位的查克拉可以打败一个大蛇丸的手续爱。
 * 假设鸣人可以上下左右四个方向移动，每移动一个距离需要花费一个单位时间，打败大蛇丸的手下不需要时间。如果鸣人查克拉消耗完了，
 * 则只可以走到没有大蛇丸手下的位置，不可以再移动到有大蛇丸手下的位置。佐助在此期间不移动，大蛇丸手下也不移动。请问，鸣人要追上佐助最少需要花费多少时间？
 *
 * 输入
 * 输入第一行包含三个整数：M,N,T.代表M行N列的地图和鸣人初始的查克拉数量T。 0 < M,N<200,0<=T<10
 * 后面是M行N列的地图，其中@代表鸣人，+代表佐助。* 代表通路，#代表大蛇丸手下。
 *
 * 输出
 * 输出包含一个整数R，代表鸣人住上佐助最少需要花费的时间，如果鸣人无法追上佐助，则输出-1。
 *
 *
 * 样例输入1
 * 4 4 1
 * #@##
 * **##
 * ###+
 * ****
 *
 * 样例输入2
 * 4 4 2
 * #@##
 * **##
 * ###+
 * ****
 * 样例输出
 * 样例输出1
 * 6
 *
 * 样例输出2
 * 4
 *
 *
 *
 * 输入样例：
 * 10 10 1
 * @#********
 * *******###
 * *******##*
 * *******##*
 * *******##*
 * *******##*
 * *******##*
 * *******##*
 * *******##*
 * *******##+
 * 输出样例：
 * 20
 *
 *
 * (tor >= 0 && tor < m && toc >= 0 && toc < n && !vis[tor][toc])：可行性剪枝，只有地图内且没有被访问过的位置才会去访问；
 * newEnergy < 0：可行性剪枝，如果能量不够，就不会访问下一个位置；
 * totalTime + 1 >= R：最优化剪枝，要访问下一个结点时发现时间已经大于等于已知的最少时间，就不会访问；
 * totalTime + 1 >= record[tor][toc][newEnergy]：仅仅只有上述的剪枝还不够，如果我们发现 在同样的查克拉状况下来到了同样的地点但是用的时间更长 ，说明走了一条远路，不再访问。
 *
 * @author wangjianqiang24
 * @date 2020/11/18
 */
public class NarutoSasuke {

	public static void main(String[] args) {

		NarutoSasuke narutoSasuke = new NarutoSasuke(4,4);

		narutoSasuke.points[0] = new char[]{'#','@','#','#'};
		narutoSasuke.points[1] = new char[]{'*','*','#','#'};
		narutoSasuke.points[2] = new char[]{'#','#','#','+'};
		narutoSasuke.points[3] = new char[]{'*','*','*','*'};
		//narutoSasuke.catchSas(0,1,1);
		//narutoSasuke.catchSas(0,1,2);
		int t = 2;
		narutoSasuke.init(t);
		narutoSasuke.catchSas(0,1,t);
		System.out.println(narutoSasuke.minLines == Integer.MAX_VALUE ? -1 : narutoSasuke.minLines);

		narutoSasuke = new NarutoSasuke(10,10);
		narutoSasuke.m1();

	}


	void m1(){
		points[0] = new char[]{'@','#','*','*','*','*','*','*','*','*'};
		points[1] = new char[]{'*','*','*','*','*','*','*','#','#','#'};
		points[2] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[3] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[4] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[5] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[6] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[7] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[8] = new char[]{'*','*','*','*','*','*','*','#','#','*'};
		points[9] = new char[]{'*','*','*','*','*','*','*','#','#','+'};
		int t = 1;
		init(t);
		catchSas(0,0,t);
		System.out.println(minLines == Integer.MAX_VALUE ? -1 : minLines);

	}





	void init(int t){
		cc = new int[M][N][t+1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N ; j++) {
				for (int k = 0; k <= t ; k++) {
					cc[i][j][k] = Integer.MAX_VALUE;
				}
			}

		}

	}


	public NarutoSasuke(int m, int n) {
		M = m;
		N = n;
		points = new char[m][n];
		routes = new int[m][n];
	}

	int M;
	int N;
	char[][] points;

	int minLines = Integer.MAX_VALUE;
	int lines = 0;
	//查克拉数量
	int[][][] cc;

	int[][] routes;


	/**
	 *
	 * @param m
	 * @param n
	 * @param t  剩余查克拉数量
	 * @return
	 */
	void catchSas(int m, int n, int t) {

		if (m < 0 || n < 0 || m >= M || n >= N) {
			return;
		}
		//已经走过
		if (routes[m][n] == 1) {
			return;
		}
		//最优性剪枝
		if (lines >= minLines){
			//如果已经计算出来的路线>= 最小的路线
			return;
		}

		//todo 可行性剪枝，在同样的查克拉状况下来到了同样的地点但是用的时间更长
		if (cc[m][n][t] < lines){
			return;
		}
		cc[m][n][t] = lines;

		//找到佐助
		if (points[m][n] == '+') {
			minLines = Math.min(minLines, lines);
			return;
		}



		//遭遇手下
		if (points[m][n] == '#') {

			if (t > 0) {
				//有查克拉，消灭手下
				t--;
			}
			else {
				//没有查克拉，我不走了
				return;
			}
		}


		lines++;
		routes[m][n] = 1;
		//看看上边能走不
		catchSas(m - 1, n, t);
		//看看下边能走不
		catchSas(m + 1, n, t);
		//看看左边
		catchSas(m, n - 1, t);
		//看看右边
		catchSas(m, n + 1, t);
		routes[m][n] = 0;
		lines--;
	}

}
