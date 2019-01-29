package LinkedList.easy;

import bean.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author Administrator
 *O(n)时间和O(1)空间
 */
public class NO234PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(0);
		ListNode pre = listNode;
		for (int i = 1; i <= 4; i++) {
			ListNode newNode = new ListNode(i);
			pre.next = newNode;
			pre = newNode;
		}
		for (int i = 4; i >= 1; i--) {
			ListNode newNode = new ListNode(i);
			pre.next = newNode;
			pre = newNode;
		}
		System.out.println(isPalindrome(listNode.next));
	
	}

	/**
	 * 
	 *2018年5月6日 下午12:21:08
	 * beats:37.62%
	 * 复杂度：
	 */
	public static boolean isPalindrome(ListNode head) {
		ListNode reverseList=null;
		ListNode pre=head;
		while(pre!=null){
			ListNode newNode=new ListNode(pre.val);
			newNode.next=reverseList;
			reverseList=newNode;
			pre=pre.next;
		}
		while(head!=null){
			if(head.val!=reverseList.val){
				return false;
			}
			head=head.next;
			reverseList=reverseList.next;
		}
		return true;
	}
}
