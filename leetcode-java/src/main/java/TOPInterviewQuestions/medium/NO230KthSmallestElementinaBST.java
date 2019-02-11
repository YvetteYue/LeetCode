package TOPInterviewQuestions.medium;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

//        Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//        Example 1:
//        Input: root = [3,1,4,null,2], k = 1
//        3
//        / \
//        1   4
//        \
//        2
//        Output: 1
//        Example 2:
//        Input: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//        / \
//        3   6
//        / \
//        2   4
//        /
//        1
//        Output: 3
//        Follow up:
//        What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
//                How would you optimize the kthSmallest routine?
public class NO230KthSmallestElementinaBST {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.right=new TreeNode(2);
        root.right=new TreeNode(4);
        System.out.println(kthSmallest(root,4));
    }


    /*
    *   中序遍历 取第k个值
     * @Date 下午5:55 2019/2/10
     * 复杂度：
     * beats： 100.00%
     **/
    public static int kthSmallest(TreeNode root, int k) {
        if(root!=null)
            dfs(root,k);
        return result;
    }
    static int res=0;
    static int result=0;
    private static void dfs(TreeNode root,int sum){
        if(root.left!=null){
            dfs(root.left,sum);
        }
        res++;
        if(res==sum){
            result=root.val;
        }
        if(root.right!=null){
            dfs(root.right,sum);
        }
    }
}
