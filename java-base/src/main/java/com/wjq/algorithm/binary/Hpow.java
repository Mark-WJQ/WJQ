package com.wjq.algorithm.binary;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/7
 */
public class Hpow {

	public static void main(String[] args) {
		Hpow h = new Hpow();
		System.out.println(h.hIndex(new int[]{0,1,3,5,6}));
	}

	public int hIndex(int[] citations) {
		int l = citations.length;
		int max = Math.min(l,citations[l-1]);
		return hIndex(1,max,citations);

	}

	public int hIndex(int start,int end,int[] citations) {

		int len = citations.length;
		int l = start;
		int r = end;
		while (l <= r) {
			int mid = l + (r-l)/2;
			int ind = Math.min(len - mid,len);
			if (citations[ind] > mid){
				l = mid + 1;
			}else if (citations[ind] == mid){
				return mid;
			} else {
				r = mid - 1;
			}
		}
		return r;
	}

}
