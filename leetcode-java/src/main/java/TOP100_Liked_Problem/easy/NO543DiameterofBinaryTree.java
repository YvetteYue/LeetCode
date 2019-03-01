package TOP100_Liked_Problem.easy;

import bean.TreeNode;

public class NO543DiameterofBinaryTree {


    public static void main(String[] args) {

    }

    /*
    *   只需要求每个左分支+右分支的深度和 ，求最大的一个即可
     * @Date 下午3:03 2019/2/24
     * 复杂度：
     * beats：100.00%
     **/
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root,0);
        return result;
    }

    int result=0;
    private int depth(TreeNode treeNode,int depth){
        if(treeNode==null) return 0;
        else{
            int left=depth(treeNode.left,depth);
            int right=depth(treeNode.right,depth);
            result=Math.max(result,left+right);
            return Math.max(left,right)+1;
        }
    }
}
