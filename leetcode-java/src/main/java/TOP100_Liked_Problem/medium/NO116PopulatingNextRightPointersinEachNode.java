package TOP100_Liked_Problem.medium;

import bean.Node;

public class NO116PopulatingNextRightPointersinEachNode {


    public static void main(String[] args) {

    }

    /*
    *  TODO 需要考虑思路
    *  、上一层指针
    *   下一层的链接到上一层指针
     * @Date 下午4:21 2019/2/24
     * 复杂度：
     * beats：100.00%
     **/
    public Node connect(Node root) {
        Node levelstart=root;
        while(levelstart!=null){
            Node cur=levelstart;
            while(cur!=null){
                if(cur.left!=null) {
                    cur.left.next=cur.right;
                }
                if(cur.right!=null&&cur.next!=null){
                    cur.right.next=cur.next.left;
                }
                cur=cur.next;
            }
            levelstart=levelstart.left;
        }
        return root;
    }
}
