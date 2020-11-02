package com.wjq.algorithm.recursion;

/**
 *
 * 任何一个正整数都可以用2 的幂次方表示。例如：
 * 137 = 2^7 + 2^3 + 2^0
 * 同时约定方次用括号来表示，即 a^b 克表示为a(b).由此可知，137可表示为：
 * 2(7)+2(3)+2(0)
 * 进一步： 7 = 2^2 + 2 + 2^0（2^1用2表示）
 * 3 = 2 + 2^0
 * 所以最后137可表示为
 * 2(2(2)+2+2(0))+2(2+2(0))+2(0)
 *
 * 又如：
 * 1315=2^10+2^8+2^5+2+1
 * 所以1315最后可表示为：
 *   2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
 *
 * 输入
 * 一个正整数n（n≤20000）。
 * 输出
 * 一行，符合约定的n的0，2表示（在表示中不能有空格）。
 * 样例输入
 * 137
 * 样例输出
 * 2(2(2)+2+2(0))+2(2+2(0))+2(0)
 *
 * @author wangjianqiang24
 * @date 2020/10/29
 */
public class Power {

	public static void main(String[] args) {

		Power power = new Power();
		System.out.println(power.pow((short) 137));

	}

	/**
	 * 由题可知 n <= 20000,所以输入可用short来表示
	 * 通过位运算可知，需要再次拆分的幂是多少
	 * 递归遍历即可
	 * 边界条件为 当幂为0或1时便不可再次分解
	 *
	 * @param s
	 * @return
	 */
	public String pow(short s){
		//TODO 对20000边界值处理
		if (s == 0){
			return "0";
		}

		if (s == 1){
			return "";
		}
		String result = "";
		for (int i = 15;i>=0;i--){
			int bit = getBit(s,i);
			if(bit == 1){
				String p = pow((short) i);
				result += ("".equals(p)?"2":"2(" +p + ")")+"+";
			}
		}
		if (result.endsWith("+")){
			return result.subSequence(0,result.length()-1).toString();
		}
		return result;

	}

	int getBit(short v,int n){
		return v >> n & 1;
	}






}
