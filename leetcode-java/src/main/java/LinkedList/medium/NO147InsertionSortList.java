package LinkedList.medium;

import bean.ListNode;

public class NO147InsertionSortList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
//		 l1.next = new ListNode(2);
//		 l1.next.next = new ListNode(1);
		ListNode res = insertionSortList(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	
	}

	//最简单版本
	/**
	 * 
	 *2018年5月6日 下午12:36:33
	 * beats:33.42%
	 * 复杂度：
	 */
	public static ListNode insertionSortList(ListNode head) {
		ListNode res=new ListNode(0);
		ListNode p=res;
		while(head!=null){
			if(head!=null){
				while(p.next!=null&&p.next.val<head.val){
					p=p.next;
				}
				ListNode tmp=p.next;
				p.next=new ListNode(head.val);
				p.next.next=tmp;
				p=res;
				head=head.next;
			}
		}
		return res.next;
	}
}
