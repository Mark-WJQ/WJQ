package com.wjq.algorithm.binary;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/7
 */
public class Divide {


	public static void main(String[] args) {
		Divide d = new Divide();
		d.divide(-2147483648,-1);
		System.out.println(1L << 31);
	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		long r = 1;
		if (dividend < 0 || divisor < 0) {
			if (!(dividend < 0 && divisor < 0)) {
				r = -1;
			}
		}
		r = cal(Math.abs((long)dividend),Math.abs((long)divisor))*r;
		if (r <= ((1 << 31) -1) && r >= -(1 << 31) ) {
			return (int) r;
		}
		return (1 << 31) -1;
	}


	long cal(long dividend, long divisor) {
		if (dividend < divisor) {
			return 0;
		}
		long d = divisor;
		long base = 0;
		while (dividend >= d) {
			d = d << 1;
			if (dividend >= d) {
				base++;
			}
		}

		long r = 1L << base;
		d = d >> 1;
		//对剩余的数字进行处理
		return r + cal(dividend - d, divisor);
	}

}
