package com.wjq.algorithm.divide;

/**
 * 归并排序
 *
 * 归并排序的时间复杂度
 * 对n个元素进行排序的时间：
 * T(n) = 2*T(n/2) + a*n (a是常数,具体多少不重要）
 * = 2*(2*T(n/4)+a*n/2)+a*n
 * = 4*T(n/4)+2a*n
 * = 4*(2*T(n/8)+a*n/4)+2*a*n
 * = 8*T(n/8)+3*a*n
 * ...
 * = 2k *T(n/2k)+k*a*n
 * 一直做到 n/2k = 1 (此时 k = log2n)，
 * T(n)= 2k *T(1)+k*a*n = 2k *T(1)+k*a*n = 2k+k*a*n
 * = n+a*(log2n)*n
 * 复杂度O(nlogn)
 *
 * @author wangjianqiang24
 * @date 2020/11/2
 */
public class MergeSort {

	public static void main(String[] args) {


		int [] a = new int[]{89,32,42,12,34,56,75};
		mergeSort(a,0,a.length-1);
		for (int i = 0; i <a.length ; i++) {
			System.out.println(a[i]);
		}

	}


	static void mergeSort(int[] a,int start,int end){
		if (start < end){
			int mid = start + (end-start)/2;
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
			merge(a,start,end,mid);
		}

	}

	/**
	 * 归并
	 * @param a 被归并数组
	 * @param start 归并起始位置
	 * @param end  归并结束位置
	 */
	static void merge(int[] a,int start,int end,int mid){
		int[] b = new int[a.length];
		int p1 = start;
		int p2 = mid+1;
		int pb = 0;
		while (p1 <= mid && p2 <= end){
			if (a[p1] > a[p2]){
				b[pb++] = a[p2++];
			}else {
				b[pb++] = a[p1++];
			}
		}

		while (p1 <=mid){
			b[pb++] = a[p1++];
		}

		while (p2<=end){
			b[pb++] = a[p2++];
		}

		for (int i=0;i<pb;i++){
			a[start+i] = b[i];
		}


	}
}
