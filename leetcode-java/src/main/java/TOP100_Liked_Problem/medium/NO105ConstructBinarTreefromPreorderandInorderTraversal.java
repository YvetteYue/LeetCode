package TOP100_Liked_Problem.medium;

import bean.TreeNode;

public class NO105ConstructBinarTreefromPreorderandInorderTraversal {
//    Given preorder and inorder traversal of a tree, construct the binary tree.
//            Note:
//    You may assume that duplicates do not exist in the tree.
//            For example, given
//    preorder = [3,9,20,15,7]
//    inorder = [9,3,15,20,7]
//    Return the following binary tree:
//            3
//            / \
//            9  20
//            /  \
//            15   7

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new NO105ConstructBinarTreefromPreorderandInorderTraversal().buildTree(preorder,inorder);
    }

    /*
    *
     * @Date 下午3:09 2019/2/16
     * 复杂度：
     * beats：91.61%
     **/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return  buildTree(preorder,inorder,0,preorder.length-1);
    }

    private int pos=0;
    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        TreeNode treeNode=new TreeNode(preorder[pos]);
        int mid=-1;
        for(int i=left;i<=right;i++){
            if(inorder[i]==preorder[pos]){
                mid=i;
                break;
            }
        }
        pos++;
        if(left<=mid-1){
            treeNode.left=buildTree(preorder,inorder,left,mid-1);
        }
        if(mid+1<=right){
            treeNode.right=buildTree(preorder,inorder,mid+1,right);
        }
        return treeNode;
    }
}
