package com.wjq.algorithm.linklist;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/23
 */
public class RevertLinkedList {


	public static void main(String[] args) {
		RevertLinkedList r = new RevertLinkedList();
		LinkNode ln1 = new LinkNode(1);
		LinkNode ln2 = new LinkNode(2);
		ln1.next = ln2;
		LinkNode ln3 = new LinkNode(3);
		ln2.next = ln3;
		LinkNode ln4 = new LinkNode(4);
		ln3.next = ln4;
		LinkNode ln5 = new LinkNode(5);
		ln4.next = ln5;
		//LinkNode cur = r.revert(ln1);
		LinkNode cur = r.revertv1(ln1);
		while (cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}


	LinkNode revert(LinkNode head){
		if (head.next == null){
			return head;
		}
		LinkNode cur = revert(head.next);
		LinkNode tail = cur;
		while (tail.next != null){
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return cur;

	}


	LinkNode revertv1(LinkNode head){
		LinkNode cur = head;
		while (cur.next != null) {
			LinkNode next = cur.next;
			cur.next = next.next;
			next.next = head;
			head = next;
		}
		return head;

	}


	static class LinkNode{

		public LinkNode(int val) {
			this.val = val;
		}

		int val;
		LinkNode next;
	}

}
