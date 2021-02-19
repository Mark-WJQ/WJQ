package com.wjq.algorithm.divide;

/**
 *
 * 考虑1,2,…,n (n <= 100000)的排列i1，i2，…，in，如果其中存在j,k，满足 j <k 且 ij > ik， 那么就称(ij
 * ,ik
 * )是这个排列的一个逆序。
 * 一个排列含有逆序的个数称为这个排列的逆序数。例如排列 263451 含有8个
 * 逆序(2,1),(6,3),(6,4),(6,5),(6,1),(3,1),(4,1),(5,1)，因此该排列的逆序数就是8。
 * 现给定1,2,…,n的一个排列，求它的逆序数。
 *
 * 笨办法：O(n2
 * )
 * 分治O(nlogn)：
 * 1） 将数组分成两半，分别求出左半边的逆序数和右半边的逆序数
 * 2） 再算有多少逆序是由左半边取一个数和右半边取一个数构成(要求O(n)实
 * 现） 的关键：左半边和右半边都是排好序的。比如，都是从大到小排序的。这
 * 样，左右半边只需要从头到尾各扫一遍，就可以找出由两边各取一个数构成的
 * 逆序个数
 *
 * 总结：
 * 由归并排序改进得到，加上计算逆序的步骤
 * MergeSortAndCount: 归并排序并计算逆序数
 *
 * @author wangjianqiang24
 * @date 2020/11/3
 */
public class MergeSortAndCount {


	public static void main(String[] args) {
		int[] a = new int[] {2, 6, 3,4,5,1,1};
		System.out.println(sortAndCount(a, 0, a.length - 1));
		for (int i =0;i < a.length;i++){
			System.out.println(a[i]);
		}
	}


	static int sortAndCount(int[] a, int start, int end) {

		int count = 0;
		if (start < end) {
			int mid = start + (end - start) / 2;
			count += sortAndCount(a, start, mid);
			count += sortAndCount(a, mid + 1, end);
			count += merge(a, start, end, mid);
		}
		return count;
	}


	static int merge(int[] a, int start, int end, int mid) {
		int[] b = new int[end - start + 1];
		int pb = 0;
		int i = start;
		int j = mid + 1;
		int count = 0;

		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				//不包含当前比较的j
				//当a[i] <= a[j] 时，计数比a[i]小的a[0……j-1]
				count += (j -1)- mid;
				b[pb++] = a[i++];
			}
			else {
				//count ++;
				b[pb++] = a[j++];
			}
		}


		while (i <= mid) {
			count += (j - 1) - mid;
			b[pb++] = a[i++];

		}
		while (j <= end) {
			b[pb++] = a[j++];
		}

		for (int k = 0; k < pb; k++) {
			a[start + k] = b[k];
		}
		return count;

	}

}
