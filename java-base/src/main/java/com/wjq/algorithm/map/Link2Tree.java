package com.wjq.algorithm.map;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/10
 */
public class Link2Tree {


	public static void main(String[] args) {
		int[] nums = new int[]{-10,-3,0,5,9};
		ListNode head = new ListNode(nums[0]);
		ListNode pre = head;
		for (int i = 1; i < nums.length; i++) {
			pre.next = new ListNode(nums[i]);
			pre = pre.next;
		}

		Link2Tree l2t = new Link2Tree();
		l2t.sortedListToBST(head);
	}

	public TreeNode sortedListToBST(ListNode head) {
		ListNode cur = head;
		//树的根节点
		TreeNode th = null;
		//最大节点
		TreeNode tl = null;
		while (cur != null) {
			TreeNode tn = new TreeNode(cur.val);
			cur = cur.next;
			//初始化树节点
			if (th == null) {
				th = tn;
				tl = tn;
				continue;
			}
			//先插入
			tl.right = tn;
			tl = tn;
			//在翻转
			//翻转规则是对最小不平衡树进行翻转，将该树的根节点（root）与右子树的根节点进行翻转(right)，使得 right.left = root,原来right节点的左子树left，添加成root.left
			//所以首先找到最小不平衡树
			//重新定位根节点
			TreeNode min = getMin(th);
			if (min == null) {
				continue;
			}
			//新的根节点
			TreeNode nr = min.right;
			//调换位置
			min.right = nr.left;
			nr.left = min;
			if (pre != null) {
				pre.right = nr;
			}
			if (pre == null) {
				th = nr;
			}
			b = null;
			pre = null;
		}
		return th;

	}

	TreeNode getMin(TreeNode root) {
		getHeight(root);
		return b;
	}

	//最小不平衡树根节点
	TreeNode b;
	TreeNode pre;

	int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int l = getHeight(node.left) ;
		int r = getHeight(node.right);
		if (Math.abs(l - r) > 1 && b == null) {
			//找到最小树
			b = node;
			return Math.max(l, r) +1;
		}
		if (b != null && pre == null) {
			//最小树的父节点
			pre = node;
		}
		return Math.max(l, r) +1;
	}


	public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

	public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
