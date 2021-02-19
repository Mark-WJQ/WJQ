package com.wjq.algorithm.dynamic;

/**
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 其实最关键的还是对于结果的缓存，已知推未知
 *
 * @author wangjianqiang24
 * @date 2020/11/10
 */
public class UnglyNum {


	public static void main(String[] args) {
		UnglyNum num = new UnglyNum();
		System.out.println(num.find(10));
		System.out.println(num.findv1(15));
	}


	/**
	 * 该解法会因为需要缓存的数据太大而内存溢出
	 * @param n
	 * @return
	 */
	long find(int n){
		byte[] nums = new byte[25600];
		nums[1] = 1;
		int k = 1;
		int num = 1;
		while (k < n){
			num++;
			if (num%2==0){
				int r = num/2;
				if (nums[r] == 1){
					nums[num] = 1;
					k++;
					continue;
				}
			}
			if (num%3==0){
				int r = num/3;
				if (nums[r] == 1){
					nums[num] = 1;
					k++;
					continue;
				}
			}

			if (num%5==0){
				int r = num/5;
				if (nums[r] == 1){
					nums[num] = 1;
					k++;
					continue;
				}
			}
		}
		return num;
	}

	int findv1(int n){
		int i2=0,i3=0,i5=0;
		int[] nums = new int[n];
		nums[0] = 1;
		for (int i = 1;i<n;i++){
			//实现有序存放，丑数与2,3,5相乘依然是丑数，对于每个因子有自己的标志来表示当前计算至哪个位置
			int ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
			nums[i] = ugly;
			if (ugly == nums[i2]*2) i2++;
			if (ugly == nums[i3]*3) i3++;
			if (ugly == nums[i5]*5) i5++;
		}
		return nums[n-1];

	}

}
