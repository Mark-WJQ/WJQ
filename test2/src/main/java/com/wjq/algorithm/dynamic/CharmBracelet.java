package com.wjq.algorithm.dynamic;

/**
 * 背包问题
 *
 * 有N件物品和一个容积为M的背包。第i件物品的体积w[i],价值d[i].求解将哪些物品装入背包可使价值总和最大。
 * 没见物品只有一件，可以选择放或者不放。(N<= 3500,M <=13000)
 *
 * 用 F[i][j] 表示取前i种物品，使它们总体积不超过j的最优取法取得的价值总和。
 * 要求F[N][M]
 * 边界
 * if(w[1] <= j){
 *     F[1][j] = d[1];
 * }else{
 *     f[1][j] = 0;
 * }
 * 递推 F[i][j] = max(F[i-1][j],F[i-1][j-w[i]]+d[i])
 * 取或不取第i种物品，两者选优(j-w[i] >= 0 才有第二项)
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/15
 */
public class CharmBracelet {

	public static void main(String[] args) {
		CharmBracelet charmBracelet = new CharmBracelet();
		System.out.println(charmBracelet.pac(6,4));
	}


	int w[] = new int[]{1,2,3,2};
	int[] d = new int[]{4,6,12,7};

	/**
	 *
	 * @param m 背包容积
	 * @param n 物品个数
	 * @return
	 */
	int pac(int m,int n){
		int[][] r = new int[n+1][m+1];
		for (int i = 1; i <= m; i++) {
			if (w[0] <= i){
				r[1][i] = d[0];
			}else {
				r[1][i] = 0;
			}
		}

		//物品个数
		for (int i = 1; i <= n; i++) {
			//体积
			for (int j = 1; j <= m; j++) {
				if (j-w[i-1] >= 0) {
					//放第i个物品
					r[i][j] = r[i - 1][j - w[i-1]] + d[i-1];
				}
				//不放第i个物品
				r[i][j] = Math.max(r[i-1][j],r[i][j]);
			}
		}
		return r[n][m];
	}



}
