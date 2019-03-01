package tree.easy;

import bean.TreeNode;

public class NO235LowestCommonAncestorofaBinarySearchTree {


    public static void main(String[] args) {

    }


    /*
    *
     * @Date 下午4:48 2019/2/24
     * 复杂度：
     * beats：100%
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left=p.val;
        int right=q.val;
        int tmp=left;
        if(left>right) {
            left=right;
            right=tmp;
        }
        while(true){
            if(left<=root.val&&root.val<=right) return root;
            else if(left<root.val&&right<root.val) root=root.left;
            else if(root.val<right&&root.val<left) root=root.right;
        }
    }
}
