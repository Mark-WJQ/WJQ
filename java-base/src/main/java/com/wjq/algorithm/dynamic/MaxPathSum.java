package com.wjq.algorithm.dynamic;

import java.util.Deque;
import java.util.LinkedList;

//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
//
//
// 示例 1：
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
//
//
// 示例 2：
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/4
 */
public class MaxPathSum {

	public static void main(String[] args) {

		Integer[] nums = new Integer[] {9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6};
		TreeNode root = init(nums);
		System.out.println(getMaxPathSum(root));
	}


	//初始化节点，反序列层序
	static TreeNode init(Integer[] nums) {
		TreeNode node = new TreeNode(nums[0]);
		Deque<TreeNode> deque = new LinkedList<>();
		deque.push(node);
		int i = 1;
		while (!deque.isEmpty() && i < nums.length) {
			TreeNode tn = deque.pollFirst();
			Integer left = nums[i++];
			if (left != null) {
				tn.left = new TreeNode(left);
				deque.add(tn.left);
			}
			if (i >= nums.length) {
				break;
			}
			Integer right = nums[i++];
			if (right != null) {
				tn.right = new TreeNode(right);
				deque.add(tn.right);
			}
		}
		return node;
	}

	static int getMaxPathSum(TreeNode root) {
		getPathSum(root);

		return maxSum;
	}

	static int maxSum = Integer.MIN_VALUE;

	static int getPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//如果子树的路径和<0的话，就没必要往上加了，加上去反而会影响父节点的最大和
		int left = Math.max(getPathSum(root.left), 0);
		int right = Math.max(0, getPathSum(root.right));
		//所以一个二叉树的根节点路径和，根节点左子树的最大路径和 + 右子树最大路径和 + 当前节点路径值
		int v = root.val + left + right;
		//一棵树中最大路径和的是它子树的最大路径和
		maxSum = Math.max(maxSum, v);
		//返回子树的最长路径和
		return root.val + Math.max(left, right);

	}


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
