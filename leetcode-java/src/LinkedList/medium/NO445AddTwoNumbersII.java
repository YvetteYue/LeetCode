package LinkedList.medium;

import java.util.Stack;

import bean.ListNode;

/**
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 * @author Administrator
 *
 */
public class NO445AddTwoNumbersII {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		 l1.next = new ListNode(9);
		 l1.next.next=new ListNode(4);
		ListNode l2 = new ListNode(2);
		 l2.next = new ListNode(4);
		ListNode l3 = addTwoNumbers2(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}	
	/*
	 * 
	 * 方法1:用队列，然后相加reverse
	 * 
	 * 
	 */
	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		Stack<Integer> l1Stack=new Stack<>();
		Stack<Integer> l2Stack=new Stack<>();
		ListNode l3=null;
		while(l1!=null){
			l1Stack.add(l1.val);
			l1=l1.next;
		}
		while(l2!=null){
			l2Stack.add(l2.val);
			l2=l2.next;
		}
		int tmp=0;
		while(!l2Stack.isEmpty()||!l1Stack.isEmpty()||tmp!=0){
			if(!l1Stack.isEmpty()){
				tmp+=l1Stack.pop();
			}
			if(!l2Stack.isEmpty()){
				tmp+=l2Stack.pop();
			}
			ListNode newNode=new ListNode(tmp%10);
			newNode.next=l3;
			l3=newNode;
			tmp=tmp/10;
		}
		return l3;
	}
	
	/**
	 * 方法2：先reverse，然后相加
	 * @param l1
	 * @param l2
	 * @return
	 */
	 public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		 ListNode l1rev=reverse(l1);
		 ListNode l2rev=reverse(l2);
		 ListNode l3=null;
		 int tmp=0;
		 while(l1rev!=null||l2rev!=null||tmp!=0){
			 if(l1rev!=null){
				 tmp+=l1rev.val;
				 l1rev=l1rev.next;
			 }
			 if(l2rev!=null){
				 tmp+=l2rev.val;
				 l2rev=l2rev.next;
			 }
			 ListNode newnode=new ListNode(tmp%10);
			 newnode.next=l3;
			 l3=newnode;
			 tmp=tmp/10;
		 }
		 return l3;
	 }
	
	 public static ListNode reverse(ListNode l1){
		 ListNode rev=null;
		 while(l1!=null){
			 ListNode newNode=new ListNode(l1.val);
			 newNode.next=rev;
			 rev=newNode;
			 l1=l1.next;
		 }
		 return rev;
	 }
	
}
