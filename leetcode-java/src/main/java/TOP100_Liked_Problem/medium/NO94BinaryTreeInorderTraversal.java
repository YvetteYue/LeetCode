package TOP100_Liked_Problem.medium;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NO94BinaryTreeInorderTraversal {
    //中序遍历
    /*
    *   递归版
     * @Date 下午9:30 2019/4/14
     * 复杂度：o(m)
     * beats：100%
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }

    private void dfs(TreeNode root,List<Integer> result){
        if(root==null) return;
        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right,result);
    }



    /*
    *   迭代版
     * @Date 下午9:56 2019/4/14
     * 复杂度：o(m)
     * beats：34%
     **/
    public List<Integer> inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {  //左分支
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);  //中
            curr = curr.right;  //右
        }
        return res;
    }

}
