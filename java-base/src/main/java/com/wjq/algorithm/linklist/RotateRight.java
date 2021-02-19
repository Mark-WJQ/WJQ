package com.wjq.algorithm.linklist;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/28
 */
public class RotateRight {


	public static void main(String[] args) {
		LinkNode ln1 = new LinkNode(1);
		LinkNode ln2 = new LinkNode(2);
		ln1.next = ln2;
		LinkNode ln3 = new LinkNode(3);
		ln2.next = ln3;
		LinkNode ln4 = new LinkNode(4);
		ln3.next = ln4;
		LinkNode ln5 = new LinkNode(5);
		ln4.next = ln5;
		RotateRight r = new RotateRight();
		r.rotateRight(ln1,2);
	}


/**
 * 旋转链表
 *
 * 假设链表的长度为n,count 为当前遍历过的节点
 * if（n >k）{
 *     前(n-k)个节点与后k个节点交换
 *
 *
 * }
 *
 * if(n<k){
 *     if(0 == k%n){
 *         //原链不变
 *     }else{
 *          //从头开始，看 n>k的逻辑
 *         k %= count;
 *         count = 0;
 *     }
 * }
 *
 * */

	public LinkNode rotateRight(LinkNode head, int k) {
		if (head == null){
			return head;
		}
		int count = 1;
		LinkNode cur = head;
		LinkNode end = new LinkNode();
		end.next = head;
		LinkNode start = new LinkNode();
		start.next = head;
		while (cur != null) {
			if (count > k) {
				end = end.next;
			}
			start = cur;
			cur = cur.next;
			if (cur == null && count <=k){
				k %= count;
				if (k == 0){
					return head;
				}
				count = 0;
				cur = head;
			}
			count++;
		}
		start.next = head;
		head = end.next;
		end.next = null;
		return head;
	}

	public LinkNode rotateRightv1(LinkNode head, int k) {
		if (head == null){
			return head;
		}
		int count = 1;
		LinkNode cur = head;
		LinkNode end = new LinkNode();
		end.next = head;
		LinkNode start = new LinkNode();
		start.next = head;
		while (cur != null) {
			if (count > k) {
				end = end.next;
			}
			start = cur;
			cur = cur.next;
			if (cur != null)
				count++;
		}

		if (count <= k){
			k %= count;
			if (k == 0){
				return head;
			}
			for (int i = 0; i < count- k; i++) {
				end = end.next;
			}
		}

		start.next = head;
		head = end.next;
		end.next = null;
		return head;
	}

	private static class LinkNode {

		public LinkNode() {
		}

		public LinkNode(int val) {
			this.val = val;
		}

		int val;
		LinkNode next;
	}
}
