package LinkedList.easy;

import bean.ListNode;

/*
 * 删除节点，只留tail
 * 
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3
 the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class NO237DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(0);
		ListNode pre = listNode;
		for (int i = 1; i <= 4; i++) {
			ListNode newNode = new ListNode(i);
			pre.next = newNode;
			pre = newNode;
		}
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}

	/**
	* Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 *2018年5月6日 下午12:09:39
	 * beats:100%
	 * 复杂度：o(1)
	 * 
	 */
	// 对于只知道当前当前要删除的节点posi，则只知道当前节点的后继，所以只能将next值复制到当前，删除后继即可。
	// 复杂度为o(1)
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
