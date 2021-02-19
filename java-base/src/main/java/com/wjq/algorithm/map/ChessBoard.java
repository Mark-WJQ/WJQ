package com.wjq.algorithm.map;

/**
 * 棋盘问题
 * 在一个给定形状的棋盘（形状可能是不规则的）上面摆放棋子，棋子没有区别。
 * 要求摆放时任意的两个棋子不能放在棋盘中的同一行或者同一列，请编程求解对于给定形状和大小的棋盘，
 * 摆放k个棋子的的所有可行的摆放方案C.
 *  输入
 *  输入包含多组测试数据。
 *  每组数据的第一行是两个正整数，n k,用一个空格隔开，表示了将在一个n*n的矩阵内描述棋盘，以及摆放棋子的数目。n<=8,k<=n.
 *  当为-1 -1 时表示输入结束。
 *  随后的n行描述了棋盘的形状：每行有n个字符，其中#表示棋盘区域，. 表示空白区域（数据保证不出现杜宇的空白行或空白列）
 *  输出
 *  对于每一组数据，给出一行输出，输出摆放的方案数目C（数据保证C<2^31）.
 *
 * 样例输入
 * 2 1
 * #.
 * .#
 * 4 4
 * ...#
 * ..#.
 * .#..
 * #...
 * -1 -1
 * 样例输出
 * 2
 * 1
 *
 * @author wangjianqiang24
 * @date 2020/11/17
 */
public class ChessBoard {

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard(2);
		board.board[0] = new char[]{'#','.'};
		board.board[1] = new char[]{'.','#'};
		//System.out.println(board.count(1,0));

		board = new ChessBoard(5);
		board.board[0] = new char[]{'.','.','.','#','.'};
		board.board[1] = new char[]{'.','.','#','.','.'};
		board.board[2] = new char[]{'.','#','.','.','.'};
		board.board[3] = new char[]{'#','.','.','.','.'};
		board.board[4] = new char[]{'.','#','.','.','.'};
		System.out.println(board.count(4,0));

		board = new ChessBoard(3);
		board.board[0] = new char[]{'.','.','#'};
		board.board[1] = new char[]{'.','#','.'};
		board.board[2] = new char[]{'#','.','.'};
		System.out.println(board.count(2,0));


	}

	public ChessBoard(int n) {
		this.n = n;
		result = new int[n][n];
		board = new char[n][n];
	}

	/**
	 * 摆放结果
	 */
	int[][] result;
	/**
	 * 棋盘
	 */
	char[][] board;

	int n;


	/**
	 * 在棋盘摆放k个棋子的可能性
	 *  先摆一个棋子，剩余就是对 k-1 个棋子摆放的可能性，这个第一个位置的行数 最大就是 n-k 行
	 * @param k  共有k个
	 * @param start 开始摆放 行
	 * @return
	 */
	int count(int k, int start) {
		if (k == 0) {
			return 1;
		}
		if (start >= n) {
			return 0;
		}
		//开始行的
		int num = 0;

		for (int i = start; i <= n - k; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '#') {
					if (check(i, j)) {
						result[i][j] = 1;
						num += count(k - 1, i + 1);
						result[i][j] = 0;
					}
				}
			}
		}
		return num;
	}

	//同一行同一列没有
	private boolean check(int start, int i) {
		for (int j = 0; j < n; j++) {
			if (result[start][j] == 1 || result[j][i] == 1){
				return false;
			}
		}
		return true;
	}

}
