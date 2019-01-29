package LinkedList.easy;

import bean.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class NO83RemoveDuplicatesfromSortedList {
	
	public static void main(String[] args) {
		ListNode listNode = null;
		ListNode pre = listNode;
//		for (int i = 1; i <= 1; i++) {
//			ListNode newNode = new ListNode(0);
//			pre.next = newNode;
//			pre = newNode;
//		}
		ListNode res = deleteDuplicates(listNode);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	/**
	 * 
	 *2018年5月6日 下午12:18:37
	 * beats:42.98%
	 * 复杂度：
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return head;
		ListNode listNode=new ListNode(head.val);
		ListNode pre=listNode;
		int tmp=head.val;
		while(head.next!=null){
			if(head.next.val>tmp){
				tmp=head.next.val;
				pre.next=new ListNode(tmp);
				pre=pre.next;
				pre.next=null;
			}
			head=head.next;
		}
		return listNode;
	}
}
