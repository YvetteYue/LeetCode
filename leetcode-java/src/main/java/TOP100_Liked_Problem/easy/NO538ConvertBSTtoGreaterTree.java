package TOP100_Liked_Problem.easy;

import bean.TreeNode;

import java.util.*;

public class NO538ConvertBSTtoGreaterTree {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
//        root.left.left=new TreeNode(14);
        TreeNode result=convertBST2(root);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
//        System.out.println(result.left.left.val);
    }

    /*
    *   最暴力的做法，没有考虑到BST的特殊性
     * @Date 下午6:44 2019/2/8
     * 复杂度：
     * beats：5.97%
     **/
    public static TreeNode convertBST(TreeNode root) {
        TreeNode pre=root;
        List<Integer> nums=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(pre);
        int sum=0;
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            nums.add(temp.val);
            sum+=temp.val;
            if(temp.right!=null) queue.add(temp.right);
            if(temp.left!=null) queue.add(temp.left);
        }
        Collections.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(nums.get(nums.size()-1),nums.get(nums.size()-1));
        int preSum=0;
        int posSum=0;
        for(int i=nums.size()-2;i>=0;i--){
            posSum+=nums.get(i+1);
            if(nums.get(i+1)>nums.get(i)){
                preSum=posSum;
            }
            map.put(nums.get(i),preSum+nums.get(i));
        }
        System.out.println(map);
        return convert(root,map);
    }

    private static TreeNode convert(TreeNode treeNode,Map<Integer,Integer> map){
        if(treeNode==null) return treeNode;
        else if(treeNode.left==null&&treeNode.right==null){
            treeNode.val=map.get(treeNode.val);
            return  treeNode;
        }
        treeNode.val=map.get(treeNode.val);
        TreeNode tmp=treeNode;
        tmp.left=convert(treeNode.left,map);
        tmp.right=convert(treeNode.right,map);
        return tmp;
    }

    /*
    *   BST的特点是左中右升序，那么右中左降序~
    *   求的右中左遍历！!中序遍历！！
     * @Date 下午7:12 2019/2/8
     * 复杂度：
     * beats：93.07%
     **/
    static int sum=0;
    public static TreeNode convertBST2(TreeNode root) {
        if(root!=null)
            dfs(root);
        return root;
    }

    private static void dfs(TreeNode root){
        //右
        if(root.right!=null){
            dfs(root.right);
        }
        sum+=root.val;
        //根
        root.val=sum;
        //左
        if(root.left!=null){
            dfs(root.left);
        }
    }


    private int sum1=0;
    /*
    * 根左右 累加即可
     * @Date 下午2:12 2019/4/14
     * 复杂度：O(n)
     * beats：100%
     **/
    public TreeNode convertBST3(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum1+=root.val;
            root.val=sum1;
            convertBST(root.left);
        }
        return root;
    }

}

