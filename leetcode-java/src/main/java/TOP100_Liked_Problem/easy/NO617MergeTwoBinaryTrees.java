package TOP100_Liked_Problem.easy;

import bean.TreeNode;

public class NO617MergeTwoBinaryTrees {

    /*
    *
     * @Date 下午1:14 2019/4/13
     * 复杂度：O(n) 递归
     * beats：100%
     **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }else if(t1==null&&t2!=null){
            return t2;
        }else if(t1!=null&&t2==null){
            return t1;
        }else {
            t1.val+=t2.val;
            t1.left=mergeTrees(t1.left,t2.left);
            t1.right=mergeTrees(t1.right,t2.right);
            return t1;
        }
    }

    //TODO 迭代版 用栈
}
