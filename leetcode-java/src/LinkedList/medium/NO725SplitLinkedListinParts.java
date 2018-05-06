package LinkedList.medium;

import bean.ListNode;

public class NO725SplitLinkedListinParts {

	public static void main(String[] args) {
		ListNode listNode=new ListNode(0);
		listNode.next=new ListNode(1);
		ListNode[] listNode2=splitListToParts(listNode,1);
		for(int i=0;i<listNode2.length;i++){
			while(listNode2[i]!=null){
				System.out.println(listNode2[i].val);
				listNode2[i]=listNode2[i].next;
			}
			System.out.println("//");
		}
	}

	/**
	 * 
	 *2018年5月6日 下午12:24:43
	 * beats:14.29%
	 * 复杂度：
	 */
	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] listNodes=new ListNode[k];
		ListNode pre=root;
		int num=0;
		while(pre!=null){
			num++;
			pre=pre.next;
		}
		int tmp=num/k;
		for(int i=0;i<k;i++){
			ListNode node=new ListNode(0);
			ListNode temp=node;
			for(int j=0;j<tmp;j++){
				if(root!=null){
					temp.next=new ListNode(root.val);
					root=root.next;
					temp=temp.next;
				}
			}
			if(i<num%k&&root!=null){
				temp.next=new ListNode(root.val);
				root=root.next;
				temp=temp.next;
			}
			listNodes[i]=node.next;
		}
		return listNodes;
	}
}
