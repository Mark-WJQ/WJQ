package com.wjq.algorithm.enumeration;

import java.util.Arrays;

/**
 * 熄灯问题
 * 有一个按钮组成的矩阵，其中每行有6个按钮，共5行
 * 每个按钮的位置上有一盏灯
 * 当按下一个按钮后，该按钮以及周边位置（上，下，左，右）的等都会改变状态
 *
 *
 * 与一盏灯毗邻的多个按钮被按下是，一个操作会抵消理一次操作的结果
 * 给定矩阵中的每盏灯的初始状态，求一种按按钮方案，使得所有的灯都熄灭
 *
 * 输入             输出
 * 0 1 1 0 1 0     1 0 1 0 0 1
 * 100111          110101
 * 001001          001011
 * 100101          100100
 * 011100          010000
 *
 *
 * 001010           100111
 * 101011           110000
 * 001011           000100
 * 101100           110101
 * 010100           101101
 *
 * @author wangjianqiang24
 * @date 2020/10/19
 */
public class Light {


	static char[] oris;
	static char[] lights;
	static char[] results;

	static {
		oris = new char[] {26, 39, 9, 37, 28};
		//oris = new char[] {0, 0, 0, 0, 28};
		lights = new char[5];
		results = new char[5];
	}

	/**
	 * 开关两种情况 按或不按 最多一次
	 *
	 * 枚举所有可能的按钮（开关）状态，对每个状态计算一下最后灯的情况，看是否都熄灯
	 * 一共有 30 个开关，那么状态数是 2^30,太多会超时
	 *
	 * 如何减少枚举状态数目？
	 * 基本思路：如果存在某个局部，一旦这个局部的状态被确定，那么剩余其他部分的状态
	 * 只能是确定的一种，或者不多的n种，那么只需枚举这个局部状态即可。
	 *
	 * 经过观察，发现第一行就是这样一个局部
	 * -因为第一行各开关状态确定的情况下，这些开关作用过后，将导致第一行的某些灯是亮的
	 * 某些灯是灭的。
	 * --要熄灭第一行某个亮着灯（假设位于第i列），那么唯一的方法就是按下第二行第i列的开关
	 * （因为第一行的开关已经用过了，而第三行及其后的开关不会影响到第一行）
	 *
	 * 因为开关只有两种状态，所以我们可以用二进制数来表示每一个开关，又因为每一行有6个开关，
	 * 6个bit就可以表示一行开关，用一个char即可
	 *
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		for (int k = 0; k < 64; k++) {
			char switchs = (char) k;
			lights = Arrays.copyOf(oris, oris.length);
			for (int j = 0; j < 5; ++j) {
				results[j] = switchs;
				for (int i = 0; i < 6; i++) {
					if (getBit(switchs, i) == 1) {
						char fr = lights[j];
						if (i > 0) {
							fr = flipBit(fr, i - 1);
						}
						fr = flipBit(fr, i);
						if (i < 5) {
							fr = flipBit(fr, i + 1);
						}
						lights[j] = fr;
					}
				}
				if (j < 4){
					lights[j+1] ^= switchs;
				}
				switchs = lights[j];
			}
			if (lights[4] == 0){
				System.out.println("结果为:");
				for (int i = 0;i<5;i ++){
					for (int j = 0;j<6;j++){
						System.out.print(getBit(results[i],5-j) + " ");
					}
					System.out.println();
				}
				break;
			}
		}

	}


	/**
	 * 设置c的第i为为v
	 * @param c
	 * @param i
	 * @param v
	 */
	static char setBit(char c, int i, int v) {
		if (v == 1) {
			c |= (1 << i);
		}
		else {
			c &= ~(1 << i);
		}
		return c;
	}

	/**
	 * 获取c中第i位bit
	 * @param c
	 * @param i
	 * @return
	 */
	static int getBit(char c, int i) {
		return c >> i & 1;
	}

	/**
	 * 将c中第i位的bit翻转
	 * @param c
	 * @param i
	 */
	static char flipBit(char c, int i) {
		return c ^= (1 << i);
	}

}
