package TOP100_Liked_Problem.medium;

import bean.TreeNode;

public class NO337HouseRobberIII {



    /*
    *    搜索
     * @Date 下午10:54 2019/5/4
     * 复杂度：o(m)
     * beats：100%
     **/
    public int rob(TreeNode root) {
        int[] result=rob1(root);
        return Math.max(result[0],result[1]);
    }


    private int[] rob1(TreeNode root){
        if(root==null) return new int[2];
        int[] left=rob1(root.left);
        int[] right=rob1(root.right);
        int l1=left[0]+right[0]+root.val; //当前点+非子节点
        int r1=Math.max(left[0],left[1])+Math.max(right[0],right[1]);   //不包括当前点+（子节点或子子节点中最大的）left和right
        return new int[]{l1,r1};
    }



}
