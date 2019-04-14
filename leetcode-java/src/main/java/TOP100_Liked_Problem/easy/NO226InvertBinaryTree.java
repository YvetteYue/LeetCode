package TOP100_Liked_Problem.easy;

import bean.TreeNode;

public class NO226InvertBinaryTree {


    /*
    *
     * @Date 上午11:54 2019/4/14
     * 复杂度：O(m) 递归版
     * beats：100%
     **/
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        else{
            TreeNode left=invertTree(root.left);
            TreeNode right=invertTree(root.right);
            root.left=right;
            root.right=left;
            return root;
        }
    }



}
