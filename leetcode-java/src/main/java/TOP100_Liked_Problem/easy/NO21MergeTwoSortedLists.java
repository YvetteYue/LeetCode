package TOP100_Liked_Problem.easy;

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
	
	/**
	 * 
	 *2018年5月6日 下午12:17:12
	 * beats:71.32%
	 * 复杂度：
	 */
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
    
    /**
	 * 1.l1>l2 那么循环l1;2.l1<l2那么循环l2;3.l1=null&&l2!=null=>result.next=l2;4.l1!=null&&l2=null =>result.next=l1
	 *2019年4月7日 下午22:58:12
	 * beats:100%
	 * 复杂度：o(n)
	 */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode tmp=new ListNode(-1);
        ListNode result=tmp;
        while(l1!=null||l2!=null){
            while(l1!=null&&l2!=null&&l1.val<=l2.val){
                result.next=l1;
                l1=l1.next;
                result=result.next;
            }
            while(l1!=null&&l2!=null&&l1.val>=l2.val){
                result.next=l2;
                l2=l2.next;
                result=result.next;
            }
            if(l1==null&&l2!=null){
                result.next=l2;
                l2=null;
            }
            if(l2==null&&l1!=null){
                result.next=l1;
                l1=null;
            }
        }
        return tmp.next;
    }
    
}
