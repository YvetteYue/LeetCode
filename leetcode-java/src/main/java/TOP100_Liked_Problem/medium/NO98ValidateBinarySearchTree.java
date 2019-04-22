package TOP100_Liked_Problem.medium;

import bean.TreeNode;

import java.util.Stack;

public class NO98ValidateBinarySearchTree {

//    Given a binary tree, determine if it is a valid binary search tree (BST).
//    Assume a BST is defined as follows:
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//    Example 1:
//    Input:
//            2
//            / \
//            1   3
//    Output: true
//    Example 2:
//
//            5
//            / \
//            1   4
//            / \
//            3   6
//    Output: false
//    Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//    is 5 but its right child's value is 4.

    public static void main(String[] args) {
//        [10,5,15,null,null,6,20]
//        TreeNode treeNode=new TreeNode(2);
//        treeNode.left=new TreeNode(1);
//        treeNode.right=new TreeNode(3);
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(1);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(6);
        treeNode.right=new TreeNode(4);
        System.out.println(new NO98ValidateBinarySearchTree().isValidBST(treeNode));
    }

    /*
    *   先序遍历升序即可，需要考虑的是比较的pre开始没有值，需要判断，不能简单的设置为int最小值
     * @Date 上午11:57 2019/2/15
     * 复杂度：
     * beats：100.00%
     **/
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
         isInvalid(root);
         return flag;
    }
    private int pre;
    private boolean start=false;
    private boolean flag=true;
    //左根右升序即可
    private void isInvalid(TreeNode root){
        if(!flag) return;
        if(root.left!=null){
            isInvalid(root.left);
        }
        if(!start){
            pre=root.val;
            start=true;
        }else {
            if (pre < root.val) {
                pre = root.val;
            } else {
                flag = false;
                return;
            }
        }
        if(root.right!=null){
            isInvalid(root.right);
        }
    }



    private int pre2=Integer.MIN_VALUE;
    private boolean flag2=true;
    /*
    *   考虑到最小值是Integer.MIN_VALUE
     * @Date 下午11:20 2019/4/20
     * 复杂度：
     * beats：
     **/
    public boolean isValidBST2(TreeNode root) {
        if(root==null) return true;
        boolean bool=isValidBST(root.left);
        if(flag){
            pre=root.val;
            flag=false;
        }else if(pre<root.val){
            pre=root.val;
        }else return false;
        boolean bool2=isValidBST(root.right);
        return bool&&bool2;
    }

    //先序遍历
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        double inorder=-Double.MAX_VALUE;
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.val<=inorder) return false;
            inorder=root.val;
            root=root.right;
        }
        return true;
    }

}
