package com.wjq.algorithm.linklist;

/**
 * 翻转单链表，每隔K个元素翻转一次
 * @author wangjianqiang24
 * @date 2020/12/28
 */
public class RevertLinkedListK {


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
		RevertLinkedListK r = new RevertLinkedListK();
		r.revert(ln1,2);
	}


	/**
	 * 是对单链表翻转的升级
	 * 假设链表长度为n
	 * 共有 x = n/k; 段需要翻转
	 * 所以遍历链表，每隔k个元素翻转一次
	 * 注意链表的连接
	 *
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	LinkNode revert(LinkNode head,int k){
		if (k <= 1){
			return head;
		}
		LinkNode dum = new LinkNode();
		LinkNode pre = dum;
		pre.next = head;
		LinkNode cur = head;
		int count = 1;
		while (cur != null){
			cur = cur.next;
			if (cur == null){
				break;
			}
			count++;
			if (count == k){
				LinkNode temp = pre.next;
				pre.next = revert(pre.next,cur);
				pre = temp;
				cur = temp;
				count = 0;
			}
		}
		return dum.next;
	}



	LinkNode revert(LinkNode head, LinkNode tail){
		LinkNode cur = head;
		LinkNode stop = tail.next;
		while (cur.next != stop){
			LinkNode next = cur.next;
			cur.next = next.next;
			next.next = head;
			head = next;
		}
		return head;
	}



	static class LinkNode {
		public LinkNode() {
		}

		public LinkNode(int val) {
			this.val = val;
		}

		int val;
		LinkNode next;
	}

}
