package LinkedList.easy;

import bean.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 *
 */
public class NO203RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
//		 l1.next = new ListNode(8);
//		 l1.next.next=new ListNode(2);
		 ListNode listNode=removeElements(l1,2);
		 while (listNode!=null) {
			System.out.println(listNode.val);
			listNode=listNode.next;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		while(head!=null&&head.val==val){
			head=head.next;
		}
		ListNode pre=head;
		while(pre!=null&&pre.next!=null){
			if(pre.next.val==val){
				pre.next=pre.next.next;
			}else {
				pre=pre.next;
			}
		}
		return head;
	}
}
