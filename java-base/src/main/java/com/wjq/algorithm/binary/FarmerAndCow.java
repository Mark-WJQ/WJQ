package com.wjq.algorithm.binary;

import java.util.Arrays;

/**
 * 农夫与奶牛
 * 农夫john建造了一座很长的畜栏，它包括N（2<=N<=1000000）个隔间，这些小隔间的位置为
 * X0,……,XN-1(0<= Xi<=10亿，均为整数，各不相同)
 *
 * John 的C(2<=C<=N)头牛眉头分到一个房间。牛都希望互相离得远点省的互相打扰。怎样才能是任意两头牛之间的最小距离尽可能的大。
 * 这个最大的最小距离是多少？
 *
 *
 * 本体有两种解决方案，一种使用暴力求解，一种使用二分法求解
 * 1. 暴力求解
 *  由题可知牛棚总距离最大为10亿，有C头牛，可得牛之间的最大的最小距离为 D = 10亿/C
 *   我们从距离D开始尝试，然后D= D-1，知道尝试出可以放下所有牛的最大距离，这个过程中可能全部尝试完也没有结果
 *   每尝试一次的时间复杂度为O(N),尝试次数为10亿/C
 *
 * 2. 二分求解
 *  从暴力求解法中可以知道，需要加快尝试的速度， 假设我们当前尝试距离 D = （L+R）/2
 *  满足条件，那小于D的距离就不需要尝试可定都可以放下。
 *  那大于D的距离有可能满足，此时我们可保存D，L = D+1，来求出新的二分距离，来看是否满足
 *  如果不满足则此时 R = D-1，来求一个更小的距离D，循环操作 L <= R,最终找到合适的D
 *  每尝试一次的复杂度不变 O(n),尝试次数 log(10亿/C)
 *
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/1
 */
public class FarmerAndCow {
	//牛个数
	int C = 3;
	//牛棚个数
	int N = 5;
	//牛棚的坐标位置，无序
	int X[] = new int[N];

	/**
	 * 按距离d来安排牛
	 * @param d
	 * @return true 可以安排成功  false  安排不成功
	 */
	public boolean fit(int d){
		//当前牛棚
		int cur = X[0];
		//当前安排牛数量，第一头牛放在第一个牛棚中
		int c = 1;
		for (int i = 1;i < N;i++){
			if (X[i]-cur >= d){
				cur = X[i];
				c++;
			}
			if (c >= C){
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		FarmerAndCow cow = new FarmerAndCow();
		cow.X = new int[]{1,2,8,4,9};
		//初始化 N，C，X
		System.out.println(cow.findD() + 1);

	}



	int findD(){
		//首先对牛棚进行排序
		Arrays.sort(X);
		int l = X[0];
		int right = X[N-1]/C;
		int result= -1;
		while (l <right){
			int d = (l + right)/2;
			if (fit(d)){
				result = d;
				l = d+1;
			}else {
				right = d-1;
			}
		}

		return result;
	}


}
