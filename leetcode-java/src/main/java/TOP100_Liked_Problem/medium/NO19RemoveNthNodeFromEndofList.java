package TOP100_Liked_Problem.medium;

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

	//
	/**
	 * 最基础版本 
	 *2018年5月6日 下午12:34:53
	 * beats:27.74%
	 * 复杂度：
	 */
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


	/*
	*	two pass
	 * @Date 下午7:50 2019/4/14
	 * 复杂度：o(n)
	 * beats：100%
	 **/
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		int count=0;
		ListNode t1=head;
		ListNode t2=new ListNode(0);
		t2.next=head;
		while(t1!=null){
			t1=t1.next;
			count++;
		}
		ListNode first=t2;
		int res=count-n;
		while(res>0){
			first=first.next;
			res--;
		}
		first.next=first.next.next;
		return t2.next;
	}


	/*
	*	one pass
	*	两个指针~ p1先移动n+1次 说明 p1和p2指针中间有n个点，然后两个指针同时移动，当第p1是null时，说明p2位置的next恰好要删除
	 * @Date 下午7:56 2019/4/14
	 * 复杂度：o(n)
	 * beats：100%
	 **/
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode first=dummy;
		ListNode second=dummy;
		//注意是n+1个 因为 first 比head多一个点
		for(int i=0;i<=n;i++){
			first=first.next;
		}
		while(first!=null){
			first=first.next;
			second=second.next;
		}
		second.next=second.next.next;
		return dummy.next;
	}
}
