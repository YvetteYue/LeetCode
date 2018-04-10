package LinkedList.medium;

import bean.ListNode;

public class NO328OddEvenLinkedList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
		 l1.next.next=new ListNode(3);
		 ListNode res=oddEvenList(l1);
		 while(res!=null){
			 System.out.println(res.val);
			 res=res.next;
		 }
	}
	
	public static ListNode oddEvenList(ListNode head) {
		ListNode odd=new ListNode(0);
		ListNode oddpre=odd;
		ListNode even=new ListNode(0);
		ListNode evenpre=even;
		while(head!=null){
			if(head!=null){
				oddpre.next=new ListNode(head.val);
				oddpre=oddpre.next;
				head=head.next;
			}
			if(head!=null){
				evenpre.next=new ListNode(head.val);
				evenpre=evenpre.next;
				head=head.next;
			}
		}
		oddpre.next=even.next;
		return odd.next;

	}
}
