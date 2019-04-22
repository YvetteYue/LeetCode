package TOP100_Liked_Problem.easy;

import bean.TreeNode;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//        But the following [1,2,2,null,3,null,3] is not:
//        1
//        / \
//        2   2
//        \   \
//        3    3
//        Note:
//        Bonus points if you could solve it both recursively and iteratively.
public class NO101SymmetricTree {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(3);
        System.out.println(isSymmetric(treeNode));
    }


    /*
    *    递归版
    *    考虑当面：1.treenode==null  ->true
    *             2. 左右均为null ——》true
    *             3.左右有一个不为null -》false
    *             4.其他情况，左右相等 ：左值等于右值，左左等于右右，左右等于右左
    *
     * @Date 上午11:21 2019/1/31
     * 复杂度：98.76%
     * beats：
     **/
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return equalLR(root.left,root.right);
    }


    private static boolean equalLR(TreeNode left,TreeNode right){
        if((left==null&&right!=null)||(left!=null&&right==null)){
            return false;
        }
        if(left==null&&right==null) return true;
        else if(left.left==null&&left.right==null&&right.left==null&&right.right==null&&left.val==right.val){
            return true;
        } else if(left.val==right.val&&equalLR(left.left,right.right)&&equalLR(left.right,right.left)){
            return true;
        }
        return false;
    }

    /*
    *
    *
    *
    *
     * @Date 上午11:31 2019/1/31
     * 复杂度：
     * beats：
     **/
    public static boolean isSymmetric1(TreeNode root) {
//        if(root==null) return true;
//        while(root.left!=null &&root.right!=null){
//
//        }
        return false;
    }

    //递归版 100%
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        else return dfs(root.left,root.right);
    }
    
    private boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        else if((left!=null&&right==null)||(right!=null&&left==null)){
            return false;
        }else{
            if(left.val==right.val){
                return dfs(left.left,right.right)&&dfs(left.right,right.left);
            }else return false;
        }
    }
}
