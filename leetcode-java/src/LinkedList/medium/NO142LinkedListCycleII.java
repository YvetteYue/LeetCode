package LinkedList.medium;

import bean.ListNode;

public class NO142LinkedListCycleII {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		 l1.next = new ListNode(2);
		 l1.next.next = new ListNode(1);
		ListNode res = detectCycle(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public  static ListNode detectCycle(ListNode head) {
		ListNode ta=head;
		ListNode tb=head;
		while(ta!=tb&&ta!=null&&tb!=null){
			ta=ta.next;
			tb=tb.next.next;
		}
		if(ta!=null&&tb!=null){
			return ta;
		}
		return null;
		

	}
}
