package TOP100_Liked_Problem.medium;

import bean.ListNode;

public class NO148SortList {

//    Sort a linked list in O(n log n) time using constant space complexity.
//    Example 1:
//    Input: 4->2->1->3
//    Output: 1->2->3->4
//    Example 2:
//    Input: -1->5->3->4->0
//    Output: -1->0->3->4->5

    public static void main(String[] args) {
        ListNode root=new ListNode(4);
        root.next=new ListNode(2);
        root.next.next=new ListNode(1);
        root.next.next.next=new ListNode(3);
        ListNode result=sortList(root);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    /*
    *  直接插入排序
     * @Date 上午11:09 2019/2/11
     * 复杂度：o(n^2)
     * beats：1.88%
     **/
    public static ListNode sortList(ListNode head) {
        ListNode sortedList=new ListNode(-1);
        while(head!=null){
            int tmp=head.val;
            ListNode pre=sortedList;
            while(pre!=null){
                if(pre.next==null){
                    ListNode tmpNode=head;
                    head=head.next;
                    tmpNode.next=null;
                    pre.next=tmpNode;
                    break;
                }else if(pre.next.val>tmp){
                    //下面两句注意要在前边
                    ListNode tmpNode=head;
                    head=head.next;
                    tmpNode.next=pre.next;
                    pre.next=tmpNode;
                    break;
                }else{
                    pre=pre.next;
                }
            }
        }
        return sortedList.next;
    }

    /*
    *   归并排序 //TODO
     * @Date 上午11:11 2019/2/11
     * 复杂度：
     * beats：
     **/
    public static ListNode sortList2(ListNode head) {
        return null;


    }
}

