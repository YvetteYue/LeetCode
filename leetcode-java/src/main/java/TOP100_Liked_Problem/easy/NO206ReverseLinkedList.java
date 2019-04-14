package TOP100_Liked_Problem.easy;

import bean.ListNode;

//A linked list can be reversed either iteratively or recursively. Could you implement both?
//递归和迭代方式反转链表
public class NO206ReverseLinkedList {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(0);
		ListNode pre = listNode;
		for (int i = 1; i <= 4; i++) {
			ListNode newNode = new ListNode(i);
			pre.next = newNode;
			pre = newNode;
		}
		ListNode res = reverseList1(listNode);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	/**
	 * @param head
	 * @return
	 */
	/**
	 *  * 
	 * 迭代版
	 * 只需要在创建时tail节点为null,在tail指针之前添加新节点即可，不需要pre节点
	 *2018年5月6日 下午12:15:38
	 * beats:30.7%
	 * 复杂度：
	 */
	public static ListNode reverseList1(ListNode head) {
		ListNode tail = null;
		while (head != null) {
			ListNode newNode = new ListNode(head.val);
			newNode.next = tail;
			tail = newNode;
			head=head.next;
		}
		return tail;
	}

	/**
	 * 递归版
	 *2018年5月6日 下午12:13:16
	 * beats:30.7%
	 * 复杂度：
	 */
	public static ListNode reverseList2(ListNode head) {
		// 在链表之前添加节点
		return addNodeBefore(head, null);

	}
	private static ListNode addNodeBefore(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode newNode = new ListNode(head.val);
		newNode.next = newHead;
		newHead = newNode;
		head = head.next;
		return addNodeBefore(head, newHead);
	}

	/*
	*
	 * @Date 下午3:41 2019/2/17
	 * 复杂度：
	 * beats：100%
	 **/
	public ListNode reverseList(ListNode head) {
		ListNode tmp=null;
		while(head!=null){
			ListNode p=head.next;
			head.next=tmp;
			tmp=head;
			head=p;
		}
		return tmp;
	}

	/*
	*
	 * @Date 下午12:47 2019/4/13
	 * 复杂度：O(n)
	 * beats：100%
	 **/
	public ListNode reverseList3(ListNode head) {
		ListNode result=null;
		ListNode pre=head;
		while(pre!=null){
			ListNode tmp=pre.next;
			pre.next=result;
			result=pre;
			pre=tmp;
		}
		return result;
	}
}
