package com.wjq.algorithm.recursion;


/**
 * n皇后问题
 * 输入整数 n,要求 n个国际象棋的皇后，摆在n*n 的棋盘上，互相不能攻击，输出全部方案。
 * 横，竖，对角线
 *
 * 输入一个正整数N，则程序输出N皇后问题的全部摆法。
 * 输出结果里的每一行都代表一种摆法。行里的第i个数字如果是n，就代表第i行的皇后应该放在第n列。
 * 皇后的行，列编号都是从1开始算。
 *
 * 样例输入：
 * 4
 * 样例输出：
 * 2 4 1 3
 * 3 1 4 2
 *
 * @author wangjianqiang24
 * @date 2020/10/20
 */
public class NQueen {


	/**
	 * 使用递归代替多重循环
	 * @param args
	 */
	public static void main(String[] args) {
		NQueen queen = new NQueen(8);
		queen.nQueen(0);
	}


	private int N;

	private int[] array;

	public NQueen(int n) {
		N = n;
		array = new int[N];
	}


	/**
	 * 在 0~k-1 行皇后已经摆好的情况下，摆第k行及其后的皇后
	 * @param k
	 */
	void nQueen(int k) {
		//如果操作行数已经达到最大说明已经排列完成，此时可以输出
		if (k == N) {
			print();
			return;
		}
		//检查第k行哪些节点满足皇后置放
		for (int i = 0; i < N;i++){
			//检查节点是否满足
			if (check(i,k)){
				array[k] = i;
				//第k行满足条件后开始检查第 k+1 行
				nQueen(k+1);
			}
		}

	}


	/**
	 * 检查节点是否满足
	 * @param i  第i列
	 * @param k  第k行
	 * @return
	 */
	private boolean check(int i,int k){
		for (int j = 0;j <k;j++){
			if (array[j] == i || (Math.abs(k-j) == Math.abs(array[j] -i))){
				return false;
			}
		}
		return true;
	}




	private void print() {
		for (int i = 0;i < N;i++){
			System.out.print((array[i] + 1) + " " );
		}
		System.out.println();
	}

}
