package TOP100_Liked_Problem.easy;

import bean.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NO160IntersectionofTwoLinkedLists {

    public static void main(String[] args) {

    }


    /*
    *   暴力
     * @Date 下午12:44 2019/5/2
     * 复杂度：o(m*n)
     * beats：5%
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headB!=null){
            ListNode A=headA;
            while(A!=null){
                if(headB==A){
                    return A;
                }
                A=A.next;
            }
            headB=headB.next;
        }
        return null;
    }


    /*
    *   set
     * @Date 下午12:47 2019/5/2
     * 复杂度：o(m)
     * beats：21%
     **/
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<ListNode>();
        ListNode A=headA;
        while(A!=null){
            set.add(A);
            A=A.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    /*
    *
     * @Date 下午12:55 2019/5/2
     * 复杂度：o(m+n)
     * beats：97%
     **/
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        int count1=0;
        int count2=0;
        while(A!=null){
            A=A.next;
            count1++;
        }
        while(B!=null){
            B=B.next;
            count2++;
        }
        if(count1>count2){
            for(int i=0;i<count1-count2;i++){
                headA=headA.next;
            }
        }else{
            for(int i=0;i<count2-count1;i++){
                headB=headB.next;
            }
        }

        while(headA!=null){
            if(headA==headB){
                return headA;
            }else{
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }
}
