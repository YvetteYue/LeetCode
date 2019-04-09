package TOP100_Liked_Problem.medium;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NO102BinaryTreeLevelOrderTraversal {
//    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//    For example:
//    Given binary tree [3,9,20,null,null,15,7],
//            3
//            / \
//            9  20
//            /  \
//            15   7
//            return its level order traversal as:
//            [
//            [3],
//            [9,20],
//            [15,7]
//            ]
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.right=new TreeNode(20);
        treeNode.left.right=new TreeNode(15);
        treeNode.right.right=new TreeNode(7);
        System.out.println(levelOrder2(treeNode));
    }

    /*
    *   广搜bfs  迭代法
     * @Date 下午3:10 2019/2/1
     * 复杂度：
     * beats：83.07%
     **/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        int pre=1;
        int now=0;
        List<List<Integer>> treeList=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> tmpList=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            pre--;
            tmpList.add(treeNode.val);
            System.out.println(treeNode.val);
            if(treeNode.left!=null) {
                queue.add(treeNode.left);
                now++;
            }
            if(treeNode.right!=null) {
                queue.add(treeNode.right);
                now++;
            }
            if(pre==0){
                treeList.add(new ArrayList<Integer>(tmpList));
                tmpList.clear();
                pre=now;
                now=0;
            }
        }
        return  treeList;
    }

    /*
    * 递归法
     * @Date 下午3:12 2019/2/1
     * 复杂度：
     * beats：100.00%
     **/
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        level(root,result,0);
        return result;
    }

    public static void level(TreeNode root,List<List<Integer>> result,int level) {
        if(root==null) return;
        if(level>result.size()-1){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        level(root.left,result,level+1);
        level(root.right,result,level+1);
    }

}
