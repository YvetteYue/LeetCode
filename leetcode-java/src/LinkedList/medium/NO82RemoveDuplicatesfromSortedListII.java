package LinkedList.medium;

import bean.ListNode;

public class NO82RemoveDuplicatesfromSortedListII {

	// Given a sorted linked list, delete all nodes that have duplicate numbers,
	// leaving only distinct numbers from the original list.
	// For example,
	// Given 1->2->3->3->4->4->5, return 1->2->5.
	// Given 1->1->1->2->3, return 2->3.
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(2);
		l1.next.next.next = new ListNode(2);
		l1.next.next.next.next = new ListNode(3);
		l1.next.next.next.next.next = new ListNode(4);
		ListNode res = deleteDuplicates(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		head=pre;
		while (head.next != null) {
			if (head.next.next!=null&&head.next.val == head.next.next.val) {
				int tmpval = head.next.val;
				while (head.next!=null&&head.next.val == tmpval) {
					head.next = head.next.next;
				}
			} else
				head = head.next;
		}
		return pre.next;
	}
}
