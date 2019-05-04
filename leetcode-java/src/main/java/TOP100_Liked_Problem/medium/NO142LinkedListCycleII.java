package TOP100_Liked_Problem.medium;

import bean.ListNode;

public class NO142LinkedListCycleII {

    /*
    *   就是链表判环，注意的是其实位置可能就是环
     * @Date 下午11:42 2019/5/1
     * 复杂度：o(n)
     * beats：100%
     **/
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode low=head;
        ListNode fast=head;
        do{
            if(fast==null||fast.next==null) return null;
            low=low.next;
            fast=fast.next.next;
        }while(low!=fast);
        if(low==head) return low;     //如果没有交叉点，起始点就是换，那么交叉位置就是当前位置。
        ListNode start=head;
        do{
            start=start.next;
            low=low.next;
        }while(low!=start);

        return start;
    }
}
