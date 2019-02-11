package TOP100_Liked_Problem.easy;

import bean.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NO437PathSumIII {

//    You are given a binary tree in which each node contains an integer value.
//    Find the number of paths that sum to a given value.
//    The path does not need to start or end at the root or a leaf,
//    but it must go downwards (traveling only from parent nodes to child nodes).
//    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//    Example:
//    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//            10
//            /  \
//            5   -3
//            / \    \
//            3   2   11
//            / \   \
//            3  -2   1
//    Return 3. The paths that sum to 8 are:
//            1.  5 -> 3
//            2.  5 -> 2 -> 1
//            3. -3 -> 11

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(10);
        treeNode.left=new TreeNode(5);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(2);
        treeNode.left.left.left=new TreeNode(3);
        treeNode.left.left.right=new TreeNode(-2);
        treeNode.left.right.right=new TreeNode(1);
        treeNode.right=new TreeNode(-3);
        treeNode.right.right=new TreeNode(11);
        System.out.println(pathSum(treeNode,8));

    }

    /*
    *   dfs 做法
    *   两个递归，一个findpath，记录path的个数
     * @Date 下午6:12 2019/2/9
     * 复杂度：o(n^2),最优o(nlgn)
     * beats：49.08%
     **/
    public static int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return findPath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private static int findPath(TreeNode root,int sum){
        int res=0;
        if(root==null)return res;
        if(sum==root.val) res++;
        res+=findPath(root.left,sum-root.val);
        res+=findPath(root.right,sum-root.val);
        return res;
    }


    /*
    *   TODO 没看懂  PATH SUM 系列TODO
    *   前缀数组，在dfs基础上记录每条路径的子集~
     * @Date 下午6:35 2019/2/9
     * 复杂度：o(n)
     * beats： 99.78%
     **/
//    public int pathSum2(TreeNode root, int sum) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.put(0, 1);  //Default sum = 0 has one count
//        return backtrack(root, 0, sum, map);
//    }
//
//    //BackTrack one pass
//    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
//        if(root == null)
//            return 0;
//        sum += root.val;
//        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
//        map.put(sum, map.getOrDefault(sum, 0)+1);
//        //Extend to left and right child
//        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
//        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
//        return res;
//    }

}
