package com.wjq.algorithm.enumeration;

/**
 * 完美立方
 * 形如 a^3 = b^3 + c^3 + d^3 的等式被称为完美立方等式。例如 12^3 = 6^3 + 8^3 + 10^3.
 * 编写一个程序，对人给的正整数N（N<= 100 ）,寻找所有的四元数组，使得符合完美立方，其中 a,b,c,d 大于1，小于等于N，且 b <= c <= d.
 *
 * 输入 一个整数
 * 输出：
 * 每一行输出一个完美立方。格式为 Cube = a,Triple(b,c,d)
 * 其中 a,b,c,d 所在的位置分别用四元数组代替。
 * @author wangjianqiang24
 * @date 2020/10/16
 */
public class PerfectCubic {


	public static void main(String[] args) {
		int N = 24;
		for (int a = 2;a<= N;a ++){
			for (int b =2;b<a;b++){
				for (int c = b;c < a;c++){
					for (int d = c;d < a;d++){
						if ((Math.pow(a,3)) == (Math.pow(b,3) + Math.pow(c,3) + Math.pow(d,3))){
							System.out.println("Cube = " + a +",Triple("+b + "," + c +"," + d+")");
						}
					}
				}
			}
		}



	}

}
