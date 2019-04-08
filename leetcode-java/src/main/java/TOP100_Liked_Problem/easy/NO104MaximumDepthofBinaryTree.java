/**
 * 
 */
package TOP100_Liked_Problem.easy;

import java.util.LinkedList;
import java.util.Queue;
import bean.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes 
along the longest path from the root node down to the farthest leaf node.
 *Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class NO104MaximumDepthofBinaryTree {

  /**
   * 
   *2018年7月19日 上午11:55:07
   * beats:12.5%
   * 复杂度：
   */
  public static int maxDepth(TreeNode root) {
    if(root==null) return 0;
    int max=0;
    Queue<TreeNode> treeNodes=new LinkedList<TreeNode>();
    root.val=1;
    treeNodes.add(root);
    while(!treeNodes.isEmpty()){
      TreeNode treeNode=treeNodes.poll();
      int val=treeNode.val;
      if(max<val) max=val;
      if(treeNode.left!=null){
        treeNode.left.val=val+1;
        treeNodes.add(treeNode.left);
      }
      if(treeNode.right!=null){
        treeNode.right.val=val+1;
        treeNodes.add(treeNode.right);
      }
    }
    return max;
  }
  
  /**
   * 
   * 递推式  maxdepth(root)=max(maxdepth(left),maxdepth(right))+1;
   *2018年7月19日 下午2:38:18
   * beats:100%
   * 复杂度：
   */
  public static int maxDepth2(TreeNode root) {
    if(root==null)return 0;
    if(root.left==null&&root.right==null) return 1;
    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
  
  //100%
  public int maxDepth3(TreeNode root) {
      if(root==null) return 0;
      else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
  
  public static void main(String[] args) {
    TreeNode root=new TreeNode(3);
    root.left=new TreeNode(9);
    root.right=new TreeNode(20);
    root.right.left=new TreeNode(15);
    root.right.right=new TreeNode(7);
    System.out.println(maxDepth2(root));
  }
}
