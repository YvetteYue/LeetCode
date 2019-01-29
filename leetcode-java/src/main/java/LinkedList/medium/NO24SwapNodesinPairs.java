package LinkedList.medium;

import bean.ListNode;
/**
 * 2018年5月6日 下午12:41:29
 * @author Yvette
 *
 */
public class NO24SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
		 l1.next.next = new ListNode(3);
		ListNode res = swapPairs3(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	/**
	 * 最简单版本
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs1(ListNode head) {
		ListNode list = new ListNode(0);
		ListNode pre = list;
		while (head != null) {
			if (head != null && head.next != null) {
				pre.next = new ListNode(head.next.val);
				pre = pre.next;
				pre.next = new ListNode(head.val);
				pre = pre.next;
				head = head.next.next;
			} else {
				pre.next = new ListNode(head.val);
				pre = pre.next;
				head = head.next;
			}
		}
		return list.next;

	}

	/**
	 * 使用固定空间，而且不能只是值的互换 1.递归版 2.迭代版
	 * 
	 * @param head
	 * @return
	 */

	// 递归思想，分而治之  70%
	public static ListNode swapPairs2(ListNode head) {
		if ((head == null) || (head.next == null)) {
			return head;
		}
		// 下一个节点
		ListNode n = head.next;// 头结点
		// 下一个节点时
		head.next = swapPairs2(head.next.next);
		// n的next节点是head
		n.next = head;
		return n;
	}

	// 迭代版,!!!!!重点  100%
	public static ListNode swapPairs3(ListNode head) {

		ListNode n = new ListNode(0);
		n.next=head;
		ListNode pre = n;
		while (pre.next != null && pre.next.next != null) {
			ListNode tmp = pre.next;//begin节点
			pre.next=pre.next.next;
			pre=pre.next;
			ListNode tmp2=pre.next;
			pre.next=tmp;
			pre.next.next=tmp2;
			pre=pre.next;
		}
		return n.next;
	}
	
	//最优版，太复杂	100%
	 public ListNode swapPairs(ListNode head) {
	        ListNode h = new ListNode(0);
	        h.next = head;
	        ListNode p = h;
	        while(p.next != null && p.next.next != null) {
	            ListNode temp1 = p;
	            p = p.next;
	            temp1.next = p.next;
	            ListNode temp2 = p.next.next;
	            p.next.next = p;
	            p.next = temp2;
	        }
	        return h.next;
	    }
}
