package com.wjq.algorithm.divide;

import java.util.Arrays;

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author wangjianqiang24
 * @date 2020/11/6
 */
public class MaxSubArray {


	public static void main(String[] args) {
		int[] nums = new int[] {-5, 8, -5, 1, 1, -3, 5, 5, -3, -3, 6, 4, -7, -4, -8, 0, -1, -6};
		MaxSubArray maxSubArray = new MaxSubArray(nums.length);

		System.out.println(maxSubArray(nums, 0, nums.length - 1));
		//System.out.println(result);
		System.out.println(maxSubArray.v1(nums, 0, nums.length - 1));
	}

	public MaxSubArray(int n) {
		N = n;
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(result[i], Integer.MIN_VALUE);
		}
	}


	/**
	 * 思路,动态规划
	 * 对于一个数组而言
	 * 如果sum > 0,则与后面的值相加是可以增大
	 * 如果 sum <0 则与后面值相加只会减小，所以重新开始累加
	 * @param nums
	 * @return
	 */
	int maxSubArray(int nums[]) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum >= 0) {
				sum += num;
			}
			else {
				sum = num;
			}
			res = Math.max(res, sum);
		}
		return res;
	}


	/**
	 * 这个分治方法类似于「线段树求解 LCIS 问题」的 pushUp 操作。 也许读者还没有接触过线段树，没有关系，方法二的内容假设你没有任何线段树的基础。当然，如果读者有兴趣的话，推荐看一看线段树区间合并法解决 多次询问 的「区间最长连续上升序列问题」和「区间最大子段和问题」，还是非常有趣的。
	 *
	 * 我们定义一个操作 get(a, l, r) 表示查询 a 序列 [l, r][l,r] 区间内的最大子段和，那么最终我们要求的答案就是 get(nums, 0, nums.size() - 1)。
	 * 如何分治实现这个操作呢？对于一个区间 [l, r][l,r]，我们取 m =(l + r)/2 ，
	 * 对区间 [l, m][l,m] 和 [m + 1, r][m+1,r] 分治求解。
	 * 当递归逐层深入直到区间长度缩小为 1 的时候，递归「开始回升」。这个时候我们考虑如何通过 [l, m] 区间的信息和 [m+1,r] 区间的信息合并成区间 [l, r]的信息。最关键的两个问题是：
	 *
	 * 我们要维护区间的哪些信息呢？
	 * 我们如何合并这些信息呢？
	 * 对于一个区间 [l, r]我们可以维护四个量：
	 *
	 * lSum 表示 [l, r]内以 l 为左端点的最大子段和
	 * rSum 表示 [l, r]内以 r 为右端点的最大子段和
	 * mSum 表示 [l, r] 内的最大子段和
	 * iSum 表示 [l, r] 的区间和
	 * 以下简称 [l, m] 为 [l, r]的「左子区间」，[m + 1, r] 为 [l, r] 的「右子区间」。我们考虑如何维护这些量呢（如何通过左右子区间的信息合并得到 [l, r] 的信息）？对于长度为 1 的区间 [i, i]，四个量的值都和 a_i 相等。
	 * 对于长度大于 1 的区间：
	 * 首先最好维护的是 iSum，区间 [l, r] 的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
	 * 对于 [l, r] 的 lSum，存在两种可能，它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
	 * 对于 [l, r]的 rSum，同理，它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
	 * 当计算好上面的三个量之后，就很好计算 [l, r] 的 mSum 了。我们可以考虑 [l, r] 的 mSum 对应的区间是否跨越 m
	 * ——它可能不跨越 m，也就是说 [l, r] 的 mSum 可能是「左子区间」的 mSum 和 「右子区间」的 mSum 中的一个；
	 * 它也可能跨越 m，可能是「左子区间」的 rSum 和 「右子区间」的 lSum 求和。三者取大。
	 * 这样问题就得到了解决。
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	Info maxSubArray2(int[] nums, int start, int end) {
		if (start == end) {
			return new Info(nums[start], nums[start], nums[start], nums[start]);
		}
		int m = (start + end) >> 2;
		Info l = maxSubArray2(nums, start, m);
		Info r = maxSubArray2(nums, m + 1, end);
		return plan(l, r);
	}

	private Info plan(Info l, Info r) {
		int iSum = l.iSum + r.iSum;
		int lSum = Math.max(l.lSum, l.iSum + r.lSum);
		int rSum = Math.max(r.rSum, r.iSum + l.rSum);
		int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
		return new Info(lSum, rSum, mSum, iSum);
	}


	//在序列[l,r] 中
	class Info {

		int lSum;  //以l为起点的最大序列和
		int rSum;  //以r为终点的最大序列和
		int mSum;  //l-r最大序列和
		int iSum;  //l-r序列和

		public Info(int lSum, int rSum, int mSum, int iSum) {
			this.lSum = lSum;
			this.rSum = rSum;
			this.mSum = mSum;
			this.iSum = iSum;
		}
	}


//--------以下思路想复杂了，虽然可以解决问题，但复杂度太高，没必要把所有子序列全部求出来

	/**
	 * 解题思路
	 * 问题可以分解为求连续子序列，再对子序列求和，取最大和
	 * 首先可以明确最小的序列只有1个元素
	 * 而大序列是由更小的序列组成，对更小的序列进行分割
	 * 所以第一步我们可以先取一个最小子序列，对剩余的序列再进行分割
	 * 第二次我们在第一部可以再去一个比较大的序列 left[]，剩余right[]  分别对left,right 求最大序列和
	 * 以此类推直到将最大序列取完
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	static int maxSubArray(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int result = Integer.MIN_VALUE;
		int t = nums[start];
		for (int i = start; i < end; i++) {
			int left = maxSubArray(nums, start, i);
			int right = maxSubArray(nums, i + 1, end);
			result = Math.max(Math.max(left, right), result);
			//本次遍历的值
			t += nums[i + 1];
		}
		return Math.max(t, result);
	}


	int N;
	int[][] result;

	/**
	 * 由递归解法中可知有许多重复计算的元素
	 * 我们可以将每次计算的元素保存起来
	 * 动态规划
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */

	int v1(int[] nums, int start, int end) {
		if (result[start][end] != Integer.MIN_VALUE) {
			return result[start][end];
		}

		if (start == end) {
			return nums[start];
		}
		int r = Integer.MIN_VALUE;
		int t = nums[start];
		for (int i = start; i < end; i++) {
			int left = maxSubArray(nums, start, i);
			result[start][i] = left;
			int right = maxSubArray(nums, i + 1, end);
			result[i + 1][end] = right;
			r = Math.max(Math.max(left, right), r);
			//本次遍历的值
			t += nums[i + 1];
		}
		return result[start][end] = Math.max(t, r);
	}







}
