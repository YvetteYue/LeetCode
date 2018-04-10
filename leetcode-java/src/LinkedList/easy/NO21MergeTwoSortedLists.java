package LinkedList.easy;

import bean.ListNode;

/*
 * 
 * Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 */
public class NO21MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(3);

		ListNode l2 = new ListNode(2);
		 l2.next = new ListNode(4);
		ListNode l3 = mergeTwoLists(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
	
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode l3 = new ListNode(0);
    	ListNode pre=l3;
    	ListNode newNode;
    	while(l1!=null||l2!=null){
    		if(((l1!=null&&l2!=null)&&(l1.val<=l2.val))||(l1!=null&&l2==null)){
    			newNode=new ListNode(l1.val);
    			pre.next=newNode;
    			pre=newNode;
    			l1=l1.next;
    		}else {
    			newNode=new ListNode(l2.val);
    			pre.next=newNode;
    			pre=newNode;
    			l2=l2.next;
    		}
    	}
		return l3.next;
    }
}
