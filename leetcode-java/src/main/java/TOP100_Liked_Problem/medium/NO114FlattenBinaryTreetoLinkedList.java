package TOP100_Liked_Problem.medium;

import bean.TreeNode;

import java.util.Queue;

public class NO114FlattenBinaryTreetoLinkedList {
//    Given a binary tree, flatten it to a linked list in-place.
//    For example, given the following tree:
//            1
//            / \
//            2   5
//            / \   \
//            3   4   6
//    The flattened tree should look like:
//            1
//            \
//            2
//            \
//            3
//            \
//            4
//            \
//            5
//            \
//            6

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right=new TreeNode(5);
        treeNode.right.right=new TreeNode(6);
        new NO114FlattenBinaryTreetoLinkedList().flatten(treeNode);
        while (treeNode!=null){
            System.out.println(treeNode.val);
            treeNode=treeNode.right;
        }
    }

    /*
    *
     * @Date 上午10:42 2019/2/13
     * 复杂度：
     * beats：89.66%
     **/
    public  void flatten(TreeNode root) {
        if(root!=null) {
            dfs(root);
            root.left = null;
            root.right = resultNode.right.right;
        }
    }
     TreeNode resultNode=new TreeNode(-1);
     TreeNode tmp=resultNode;
    private  void dfs(TreeNode root){
        if(root==null) return;
        if(root!=null) {
            tmp.right=new TreeNode(root.val);
            tmp=tmp.right;
            if(root.left!=null){
                dfs(root.left);
            }
            if(root.right!=null){
                dfs(root.right);
            }
        }
    }

    TreeNode prev = null;

    /*
    *   TODO finished 链表方式 不新建元素，直接修改引用方式,使用的前插法！！
    *   右左根
     * @Date 上午11:33 2019/2/13
     * 复杂度：
     * beats：
     **/
    public void flatten2(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
