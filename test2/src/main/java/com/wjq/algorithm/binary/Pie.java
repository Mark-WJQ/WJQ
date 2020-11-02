package com.wjq.algorithm.binary;

/**
 *
 * 描述
 * 我的生日要到了！根据习俗，我需要将一些派分给大家。我有N个不同口味、不同大小的派。有F个朋友会来参加我的派对，每个人会拿到一块派（必须一个派的一块，不能由几个派的小块拼成；可以是一整个派）。
 *
 * 我的朋友们都特别小气，如果有人拿到更大的一块，就会开始抱怨。因此所有人拿到的派是同样大小的（但不需要是同样形状的），虽然这样有些派会被浪费，但总比搞砸整个派对好。当然，我也要给自己留一块，而这一块也要和其他人的同样大小。
 *
 * 请问我们每个人拿到的派最大是多少？每个派都是一个高为1，半径不等的圆柱体。
 *
 * 输入
 * 第一行包含两个正整数N和F，1 ≤ N, F ≤ 10 000，表示派的数量和朋友的数量。
 * 第二行包含N个1到10000之间的整数，表示每个派的半径。
 * 输出
 * 输出每个人能得到的最大的派的体积，精确到小数点后三位。
 * 样例输入
 * 3 3
 * 4 3 3
 * 样例输出,与计算精度有关，π取多少位
 * 25.133
 *
 *  派的总体积为 V = V0+ …………+ V(N-1)
 *  理想情况下每人分到的最大体积为 avg = V/F
 *  所以没恩分到的派 <= avg
 *  使 l= 0;r = avg
 *  对v = (l +r)/2 进行二分求解，并使用该体积分割派，如果分割成功记录v，继续尝试 l = v+1
 *  如果尝试不成功 r = v-1
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/2
 */
public class Pie {


	public static void main(String[] args) {

		Pie pie = new Pie();
		System.out.println(pie.divide());
	}


	/**
	 * 派数量
	 */
	int n =3;
	/**
	 * 朋友数量
	 */
	int f=3+1;
	/**
	 * 派半径数组
	 */
	int rs[] = new int[]{4,3,3};


	/**
	 * 适配派
	 * @param vs 派体积数组
	 * @param v 每人分配的派
	 */
	public boolean fit(double[] vs, double v){
		//double cur = vs[0];
		int fri = 0;
		for (int i = 0; i <n; i++) {
			double cur = vs[i];
			double left = cur -v;
			while (left >= 0){
				fri ++;
				left = left -v;
			}
			if (fri >= f){
				return true;
			}
		}
		return false;
	}

	public double divide(){

		//计算体积
		double vs[] = new double[n];
		double total = 0;
		for (int i = 0;i<n;i++){
			vs[i] = rs[i] * rs[i] * 3.142D;
			total += vs[i];
		}
		double avg = total/f;
		double left = 0;
		double right = avg;
		double result = 0;
		while (left < right){
			double v = (left + right)/2;
			if (fit(vs,v)){
				result = v;
				left = v+0.001;
			}else {
				right = v-0.001;
			}
		}
		return result;

	}

}
