package com.wjq.algorithm.enumeration;

import java.util.Arrays;

/**
 *称硬币
 *
 * 有12枚硬币。其中有11枚真币和1枚假币。假币和真币重量不同，
 * 但不知道假币比真币轻还是重。现在，用一架天平称了这些币三次，告诉你称的结果，
 * 请你找出假币并且确定假币是轻是重。
 * 数据保证一定能找出来。
 *
 * 输入示例，表示右边重量 even 平 up 轻 down 重
 * ABCD EFGH  even
 * ABCI EFJK up
 * ABIJ BFGH even
 * 输出示例
 * K is the counterfet coin and it is light.
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/10/18
 */
public class Coin {


	static char[][] lefts = new char[3][7];


	static char[][] rights = new char[3][7];

	static char[] results = new char[3];

	static {
		lefts[0] = new char[] {'A', 'B', 'C', 'D'};
		lefts[1] = new char[] {'A', 'B', 'C', 'I'};
		lefts[2] = new char[] {'A', 'B', 'I', 'J'};
		rights[0] = new char[]{'E','F','G','H'};
		rights[1] = new char[]{'E','F','J','K'};
		rights[2] = new char[]{'E','F','G','H'};
		results[0] = 'e';
		results[1] = 'u';
		results[2] = 'e';

	}

	/**
	 * 解题思路
	 *
	 * 对于每一枚硬币先假设他是轻的，看这样是否符合称量结果。如果符合，问题解决。
	 * 如果不符合，就假设它是重的，看是否符合结果。
	 * 把所有硬币都试一遍，一定能找到特殊硬币。
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		for (char i = 'A'; i < 'A' + 13; i++) {
			//假设元素i 轻
			if (isFake(i, true)) {
				System.out.println(i +" is the counterfet coin and it is light.");
			}
			//假设元素i重
			else if (isFake(i, false)) {
				System.out.println(i +" is the counterfet coin and it is light.");
			}

		}

	}


	/**
	 * 假设是否成立
	 * @param c 被假设元素
	 * @param light 假设是否为轻
	 * @return
	 */
	static boolean isFake(char c, boolean light) {
		char[] left,right;
		for (int i =0;i<3;i++){
			//左右分配的基础是 result 以右面为基础 轻是右面轻 重是右面重
			if (light){
				left = lefts[i];
				right = rights[i];
			}else {
				left = rights[i];
				right = lefts[i];
			}
			switch (results[i]){
			case 'u':
				int p = Arrays.binarySearch(right,c);
				if (p < 0){
					return false;
				}
				continue;
			case 'e':
				int l = Arrays.binarySearch(left,c);
				int r =Arrays.binarySearch(right,c);
				if ( l >-1 || r >-1 ){
					return false;
				}
				continue;
			case 'd':
				 p = Arrays.binarySearch(left,c);
				 if (p < 0){
				 	return false;
				 }
				continue;
			default:
				continue;
			}

		}
		return true;
	}




}
