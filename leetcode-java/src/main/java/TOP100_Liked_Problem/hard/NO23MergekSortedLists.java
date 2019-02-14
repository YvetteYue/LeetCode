package TOP100_Liked_Problem.hard;

import bean.ListNode;

import java.util.*;

public class NO23MergekSortedLists {


//    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//            Example:
//    Input:
//            [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
//    Output: 1->1->2->3->4->4->5->6


    public static void main(String[] args) {
        ListNode[] listNodes=new ListNode[3];
        listNodes[0]=new ListNode(1);
        listNodes[0].next=new ListNode(4);
        listNodes[0].next.next=new ListNode(5);
        listNodes[1]=new ListNode(1);
        listNodes[1].next=new ListNode(3);
        listNodes[1].next.next=new ListNode(4);
        listNodes[2]=new ListNode(2);
        listNodes[2].next=new ListNode(6);
        ListNode listNode=new NO23MergekSortedLists().mergeKLists(listNodes);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /*
    *   优先队列
     * @Date 下午12:19 2019/2/13
     * 复杂度：
     * beats：77.68%
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode=new ListNode(-1);
        ListNode tmp=listNode;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode tmpNode:lists){
            if(tmpNode==null) continue;
            queue.add(tmpNode);
        }
        while(!queue.isEmpty()){
            ListNode node=queue.poll();
            if(queue.size()==0){
                tmp.next=node;
            }else{
                ListNode quNode=queue.peek();
                while(node!=null&&node.val<=quNode.val){
                    tmp.next=node;
                    node=node.next;
                    tmp=tmp.next;
                }
                if(node!=null)
                    queue.add(node);
            }
        }
        return listNode;
    }

    //TODO 递归二分等
}
