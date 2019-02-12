package heap.easy;

import java.util.PriorityQueue;

//        Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
//        not the kth distinct element.
//        Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains
//        initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth
//        largest element in the stream.
//        Example:
//        int k = 3;
//        int[] arr = [4,5,8,2];
//        KthLargest kthLargest = new KthLargest(3, arr);
//        kthLargest.add(3);   // returns 4
//        kthLargest.add(5);   // returns 5
//        kthLargest.add(10);  // returns 5
//        kthLargest.add(9);   // returns 8
//        kthLargest.add(4);   // returns 8
//        Note:
//        You may assume that nums' length ≥ k-1 and k ≥ 1.

public class NO703KthLargestElementinaStream {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }


}

/*
 *
 * @Date 下午3:02 2019/2/12
 * 复杂度：
 * beats：79.92%
 **/
class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            } else if (priorityQueue.peek() < nums[i]) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/*
 *
 * @Date 下午3:04 2019/2/12
 * 复杂度：
 * beats：89.32%
 **/
class KthLargest2 {

    PriorityQueue<Integer> queue = null;
    int kth = 0;

    public KthLargest2(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        kth = k;

        for (int in : nums) {
            add(in);
        }

    }

    public int add(int val) {
        if (queue.size() < kth)
            queue.offer(val);
        else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}