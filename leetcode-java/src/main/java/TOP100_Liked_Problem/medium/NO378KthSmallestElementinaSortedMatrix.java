package TOP100_Liked_Problem.medium;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class NO378KthSmallestElementinaSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix={
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(new NO378KthSmallestElementinaSortedMatrix().kthSmallest(matrix,8));
    }


    /*
    *   优先队列
     * @Date 下午1:30 2019/2/13
     * 复杂度：
     * beats：46.68%
     **/
    public  int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key[o1.value]-o2.key[o2.value];
            }
        });
        for(int[] arr:matrix){
            priorityQueue.add(new Node(arr,0));
        }
        int pos=0;
        while(pos<k){
            Node nowValue=priorityQueue.poll();
            if(priorityQueue.size()==0){
                if(pos<k){
                    return nowValue.key[nowValue.value+k-pos-1];
                }
            }else {
                Node topValue=priorityQueue.peek();
                int tmpPos=nowValue.value;
                while(true){
                    if(tmpPos==nowValue.key.length) break;
                    if(tmpPos<nowValue.key.length&&nowValue.key[tmpPos]<=topValue.key[topValue.value]){
                        pos++;
                        if(pos==k) return nowValue.key[tmpPos];
                        else tmpPos++;
                    }else {
                        priorityQueue.add(new Node(nowValue.key,tmpPos));
                        break;
                    }
                }
            }
        }
        return 0;
    }
    class Node{
        int key[];
        int value;
        Node(int[] key,int value){
            this.key=key;
            this.value=value;
        }
    }


    //TODO 二分方法！
}
