package com.wjq.algorithm.recursion;

/**
 * 放苹果
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的
 * 分法？5,1,1 和1,5,1 是同一种分法。
 *
 * 输入
 * 第一行是测试数据的数目t（ 0 <= t <= 20）. 以下每行均包含二个整数M和N，以空格分开。
 * 1 <= M,N <=10.
 *
 * 输出
 * 对输入的每组数据 M 和N，用一行输出对应的K
 *
 * 样例输入
 * 1
 * 7 3
 * 样例输出
 * 8
 *
 * 横向思考，排除干扰情况，固定其他变量，只留下一个变量，变量的变化互斥
 * 设 i 个苹果放在k个盘子里方法总数是f(i,k),则
 *  k > i时，f(i,k) = f(i,i)
 *  k<=i时，
 *  分为有盘子为空，假设有一个盘子为空，f(i,k-1)
 *  没有盘子为空 f(i-k,k)
 *  so f(i,k) = f(i,k-1) + f(i-k,k)
 *
 * @author wangjianqiang24
 * @date 2020/10/25
 */
public class Apples {

	public static void main(String[] args) {
		Apples apples = new Apples();
		System.out.println(apples.putApple(11,4));
		System.out.println(apples.f(11,4));
	}

	private int N,M;


	/**
	 * 这个解法有点问题还没想清楚
	 *
	 * 假设第一个盘子中放 k 个苹果，则要在剩余的n-1个盘子中
	 * 放 m-k个苹果
	 *
	 * @param m  m 个苹果
	 * @param n  n 个盘子
	 * @return  当盘子或苹果只剩一个时，只有一种摆法
	 */
	public int putApple (int m,int n){
		if (n == 1){
			return 1;
		}
		if (m == 0 || m== 1){
			return 1;
		}
		int result = 0;
		for (int i = m ; i >= m/2;i--){
			//在这 里 k = i;
			int r = putApple(m-i,n-1);
			System.out.println(("k =" + i + "===剩余苹果" + (m-i) + "----"+ "剩余盘子：" + (n-1)) + "摆法："+ r);
			result += r;
		}
		if (m%2 != 0){
			result -= 1;
		}

		//System.out.println("苹果：" + m + ",盘子："+ n+"，摆法："+ result);
		return result;
	}


	public int f(int m,int n){
		if ( n > m){
			return f(m,m);
		}
		//没有苹果只有一种方法不放
		if (m  == 0){
			return 1;
		}
		//没有盘子则没有放法
		if (n == 0){
			return 0;
		}

		return f(m,n-1) + f(m-n,n);


	}

}
