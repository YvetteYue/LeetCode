package TOP100_Liked_Problem.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NO239SlidingWindowMaximum {

//    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window.
//    Each time the sliding window moves right by one position. Return the max sliding window.
//        Example:
//    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//    Window position                Max
//--------------------
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
//    Follow up:
//    Could you solve it in linear time?
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] result=new NO239SlidingWindowMaximum().maxSlidingWindow(nums,3);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    /*
    *   优先队列
     * @Date 下午1:23 2019/4/29
     * 复杂度：o(n)
     * beats：43%
     **/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int[] result=new int[len-k+1];
        if(k==0) return new int[0];
        boolean[] bool=new boolean[nums.length];
        Arrays.fill(bool,false);
        Queue<Bean> priorityQueue=new PriorityQueue<>(new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                if(o1.num==o2.num){
                    return o2.pos-o1.pos;
                }
                return o2.num-o1.num;
            }
        });
        int left=0,right=0;
        while(right<nums.length){
            if(right-left<k) {
                priorityQueue.add(new Bean(nums[right], right));
                right++;
            }else{
                bool[left]=true;
                left++;
            }
            if(right-left==k&&left<=nums.length-k){
                while(!priorityQueue.isEmpty()&&bool[priorityQueue.peek().pos]){
                    priorityQueue.poll();
                }
                result[left]=priorityQueue.peek().num;
            }
        }
        return result;
    }


    class Bean{
        private int num;
        private int pos;
        Bean(int num,int pos){
            this.num=num;
            this.pos=pos;
        }
    }
}

