package TOPInterviewQuestions.easy;

import bean.TreeNode;

public class NO108ConvertSortedArraytoBinarySearchTree {

//    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//    For this problem, a height-balanced binary tree is defined as a binary tree
//    in which the depth of the two subtrees of every node never differ by more than 1.
//    Example:
//    Given the sorted array: [-10,-3,0,5,9],
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//            0
//            / \
//            -3   9
//            /   /
//            -10  5
    
    public static void main(String[] args) {
        int nums[]={};
        sortedArrayToBST(nums);
    }


    /*
    *   递归
     * @Date 下午2:50 2019/2/11
     * 复杂度：
     * beats：100%
     **/
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return dfs(null,nums,0,nums.length-1);
    }

    private  static TreeNode dfs(TreeNode treeNode,int[] nums,int begin,int end){
        int mid=(begin+end)>>1;
        treeNode=new TreeNode(nums[mid]);
        if(begin<=mid-1)
            treeNode.left=dfs(treeNode.left,nums,begin,mid-1);
        if(mid+1<=end)
            treeNode.right=dfs(treeNode.right,nums,mid+1,end);
        return treeNode;
    }
}
