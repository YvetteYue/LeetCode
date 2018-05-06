package LinkedList.medium;

import bean.ListNode;

public class NO92ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next=new ListNode(4);
		ListNode res = reverseBetween(l1, 3,4);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	/**
	 * 
	 *2018年5月6日 下午12:37:23
	 * beats:16.32%
	 * 复杂度：
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p = pre;
		ListNode begin = null;
		ListNode tmp =begin;
		ListNode t=tmp;
		int i = 1;
		while (i < m) {
			p = p.next;
			i++;
		}
		if (i == m) {
			begin = p;
		}
		int k=0;
		while (m <= i && i <= n && begin != null && begin.next != null) {
			ListNode newNode = new ListNode(begin.next.val);
			newNode.next = t;
			t = newNode;
			if(k==0){
				tmp=newNode;
				k=1;
			}
			begin = begin.next;
			i++;
		}
		p.next = t;
		tmp.next=begin.next;
		return pre.next;
	}
}
