package com.wjq.algorithm.enumeration;

/**
 * 有一种特殊的二进制密码锁，由n个相连的按钮组成（n< 30）,俺就有
 * 凹凸两种状态，用手按按钮会改变其状态。
 * 然而让人头疼的是，当你按一个按钮式，跟他相邻的菱格按钮状态也会反转。
 * 当然，如果你按的是最左或最右边的按钮，该按钮只会影响到跟他相邻的一个按钮。
 * 当前密码锁状态一直，需要解决问题是，你至少需要按多少戏按钮，才能将密码锁转变为所期望的
 * 目标状态。
 *
 * 输入
 * 两行，给出两个0、1组成的等长字符串，表示当前/目标密码锁状态
 * 其中0代表凹，1代表凸
 * 输出
 * 至少需要进行的按按钮操作次数，如果无法实现转变，则输出impossible
 *
 *
 * 思路
 * 首先确实使用枚举算法解题
 * 由于只有两种状态0,1 所以可以使用二进制来表示，且 n < 30,所以可以使用int来表示密码
 * 枚举状态有 0 ~ 2^n 种，从0开始枚举(只要找到第一个满足状态即可，是最少次数)，并且按开关，状态重置后与目标状态异或 =0 则代表成功
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/10/26
 */
public class SpecialLock {


	public static void main(String[] args) {
		SpecialLock specialLock = new SpecialLock();
		System.out.println(specialLock.lock(3,new int[]{4,0}));
	}

	public int lock(int n,int a[]){
		for(int i = 0;i< Math.pow(2,n);i++){
			int result = a[0];
			for (int j = 0;j < n;j++){
				int bit = getBit(i,j);
				if (bit == 1){
					if (j > 0){
						result =flip(result,j-1);
					}
					result = flip(result,j);
					if (j< n-1){
						result = flip(result,j+1);
					}
				}
			}
			if ((result ^ a[1]) == 0){
				return i;
			}

		}
		return -1;
	}


	/**
	 * 给指定数字k，在第n位设置bit
	 * @param k 操作数字
	 * @param n 二进制第n位
	 * @param bit 0 ，1
	 */
	int setBit(int k,int n,int bit){
		if (bit == 1){
			k |= 1 << n;
		}else {
			k &= ~(1<<n);
		}
		return k;
	}

	/**
	 * 获取数字k在第n为的bit
	 * @param k
	 * @param n
	 * @return
	 */
	int getBit(int k,int n){
		return (k>>n) & 1;
	}

	/**
	 * 反转指定数字k第n位的数字
	 * @param k
	 * @param n
	 * @return
	 */
	int flip(int k,int n){
		return k ^ (1<<n);
	}




}
