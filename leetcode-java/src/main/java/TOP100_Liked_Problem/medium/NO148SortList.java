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
        ListNode result=sortList1(root);
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
    public static ListNode sortList1(ListNode head) {
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
    *   归并排序
    *   根据快慢，可以将链表拆分成两半
     * @Date 上午11:11 2019/2/11
     * 复杂度：o(nlgn)
     * beats：97%
     **/
    public  ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        pre.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode result=new ListNode(-1);
        ListNode listNode=result;
        ListNode tmp=null;
        while(l1!=null||l2!=null){
            while(l1!=null&&l2!=null&&l1.val<=l2.val){
                tmp=l1.next;
                result.next=l1;
                result=result.next;
                l1=tmp;
            }
            while(l2!=null&&l1!=null&&l2.val<=l1.val){
                tmp=l2.next;
                result.next=l2;
                result=result.next;
                l2=tmp;
            }
            if(l2==null&&l1!=null){
                result.next=l1;
                l1=null;
            }
            if(l1==null&&l2!=null){
                result.next=l2;
                l2=null;
            }
        }
        return listNode.next;
    }
}

