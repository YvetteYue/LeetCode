package TOPInterviewQuestions.medium;

import bean.TreeNode;

import java.util.*;

public class NO103BinaryTreeZigzagLevelOrderTraversal {

//    Given a binary tree, return the zigzag level order traversal of its nodes' values.
//        (ie, from left to right, then right to left for the next level and alternate between).
//    For example:
//    Given binary tree [3,9,20,null,null,15,7],
//            3
//            / \
//            9  20
//              /  \
//              15   7
//            return its zigzag level order traversal as:
//            [
//            [3],
//            [20,9],
//            [15,7]
//            ]

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(new NO103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }


    /*
    *
     *  或者可以选择逆序就add到头部，复杂度差不太多
     * @Date 下午12:45 2019/2/23
     * 复杂度：
     * beats：89.59%
     **/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return  result;
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        treeNodeQueue.add(root);
        int times=0;
        while(!treeNodeQueue.isEmpty()){
            int size=treeNodeQueue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode=treeNodeQueue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null) treeNodeQueue.add(treeNode.left);
                if(treeNode.right!=null) treeNodeQueue.add(treeNode.right);
            }
            if(times%2!=0){
                result.add(new ArrayList<>(list));
                times++;
                list.clear();
            }else{
                Collections.reverse(list);
                result.add(new ArrayList<>(list));
                times++;
                list.clear();
            }
        }
        return result;
    }
}
