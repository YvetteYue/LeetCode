package TOP100_Liked_Problem.medium;

import bean.ListNode;

/**
 * 题目介绍：
 * 
 * 
 * 
 * Linklist *head_insert(Linklist *head,int value) //头插法，先插的元素排在后面 { Linklist
 * *p,*t; t=head; p=(Linklist *)malloc(sizeof(Linklist)); //临时新建 p->data=value;
 * p->next=t->next; //p的next=t(head)的next t->next=p; //t(head)->p return head; }
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * @author Administrator 42+65
 *
 */
public class NO2AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		 l1.next = new ListNode(8);

		ListNode l2 = new ListNode(2);
		// l2.next = new ListNode(2);
		ListNode l3 = addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	/**
	 * 
	 *2018年5月6日 下午12:41:29
	 * beats:69.69%
	 * 复杂度：
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 链表尾插法
		ListNode l3 = new ListNode(0);// head
		ListNode p = new ListNode(0);// 当前
		ListNode t = l3;// pre
		int temp = 0;
		while (l1 != null || l2 != null || temp != 0) {
			int num = 0;
			if (l1 != null) {
				num += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				num += l2.val;
				l2 = l2.next;
			}
			if (temp != 0) {
				num += temp;
				temp = 0;
			}
			if (num / 10 != 0)
				temp = num / 10;
			p = new ListNode(num % 10);
			while (t.next != null) {
				t = t.next;
			}
			t.next = p;
			t=p;
		}
		return l3.next;
	}
}

