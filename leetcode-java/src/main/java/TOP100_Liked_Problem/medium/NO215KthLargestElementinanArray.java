package TOP100_Liked_Problem.medium;

import java.util.PriorityQueue;

public class NO215KthLargestElementinanArray {

//    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
//    not the kth distinct element.
//    Example 1:
//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
//    Example 2:
//    Input: [3,2,3,1,2,4,5,5,6] and k = 4
//    Output: 4
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ array's length.

    public static void main(String[] args) {
        int nums[]={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }

    /*
    *
     * @Date 下午3:57 2019/2/12
     * 复杂度：
     * beats：70.49%
     **/
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i:nums){
            if(priorityQueue.size()<k){
                priorityQueue.add(i);
            }else if(priorityQueue.peek()<i){
                priorityQueue.poll();
                priorityQueue.add(i);
            }
        }
        return priorityQueue.peek();
    }

    //TODO 堆排序 、quicksort快排
}
