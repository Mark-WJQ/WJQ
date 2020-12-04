package com.wjq.algorithm.map;

import java.util.Arrays;

/**
 * 红与黑
 * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一块黑色的瓷砖上，只能向相邻的的黑色瓷砖移动。
 * 请写一个程序，计算你总共能够到达多少黑色的瓷砖。
 *
 * 输入
 * 包括多个数据集合。每个数据集合的第一行是两个整数W和H，分别表示X方向和y方向瓷砖的数量。W和H都不超过20.在接下来的H行中，每行包括W个字符。
 * 每个字符表示一块瓷砖的颜色，规则如下
 * 1）'.'  黑色的瓷砖
 * 2） '#' 白色的瓷砖
 * 3） '@'  黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集中唯一出现一次。
 * 当在一行中读入的是两个0时，表示输入结束。
 *
 * 输出
 * 对每个数据集，分别输出一行，显示你从初始位置触发能到达的瓷砖数（计数时包括初始位置的瓷砖）
 *
 * 样例输入
 * 6 9
 * ....#.
 * .....#
 * ......
 * ......
 * ......
 * ......
 * ......
 * #@...#
 * .#..#.
 * 0 0
 * 样例输出
 * 45
 *
 * @author wangjianqiang24
 * @date 2020/11/17
 */
public class BlackAndRed {

	public static void main(String[] args) {
		BlackAndRed blackAndRed = new BlackAndRed(6,9);
		blackAndRed.tiles[0] = new char[]{'.','.','.','.','#','.'};
		blackAndRed.tiles[1] = new char[]{'.','.','.','.','.','#'};
		for (int i = 2; i < blackAndRed.h -2; i++) {
			Arrays.fill(blackAndRed.tiles[i],'.');
		}
		blackAndRed.tiles[7] = new char[]{'#','@','.','.','.','#'};
		blackAndRed.tiles[8] = new char[]{'.','#','.','.','#','.'};
		System.out.println(blackAndRed.maxNum(7,1));

	}


	public BlackAndRed(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new char[h][w];
		old = new int[h][w];
	}

	char[][] tiles;
	int [][] old;
	int w;
	int h;

	int maxNum(int i,int j){
		if (i < 0 || j < 0 || i >= h | j >= w){
			return 0;
		}
		if (tiles[i][j] == '#'){
			return 0;
		}

		if (old[i][j] == 1){
			return 0;
		}
		int num = 1;
		old[i][j] = 1;
		num += maxNum(i-1,j);
		num += maxNum(i+1,j);
		num += maxNum(i,j-1);
		num += maxNum(i,j+1);
		return num;
	}

}
