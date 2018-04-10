package LinkedList.medium;

import bean.ListNode;

public class NO19RemoveNthNodeFromEndofList {

	// Given linked list: 1->2->3->4->5, and n = 2.
	// After removing the second node from the end, the linked list becomes
	// 1->2->3->5.
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
		 l1.next.next = new ListNode(3);
		ListNode res = removeNthFromEnd(l1,0);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	//最基础版本 	20.98%
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode l1=head;
		ListNode l2=head;
		int num=0;
		while(l1!=null){
			l1=l1.next;
			num++;
		}
		num=num-n;
		if(num==0)return head.next;
		int tmp=0;
		while(tmp<num-1){
			l2=l2.next;
			tmp++;
		}
		if(l2!=null)
			l2.next=l2.next.next;
		return head;
	}

	
}
