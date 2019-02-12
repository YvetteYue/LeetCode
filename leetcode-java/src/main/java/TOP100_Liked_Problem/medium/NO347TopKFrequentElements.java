package TOP100_Liked_Problem.medium;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class NO347TopKFrequentElements {

//    Given a non-empty array of integers, return the k most frequent elements.
//        Example 1:
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//    Input: nums = [1], k = 1
//    Output: [1]
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }

    /*
    *   map+sort/priorityqueue
     * @Date 下午3:30 2019/2/12
     * 复杂度：
     * beats：79.01%
     **/
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> tmplist = new ArrayList<>(map.entrySet());
        Collections.sort(tmplist, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(tmplist.get(i).getKey());
        }
        return list;
    }

    //TODO 最优解？ hash+heap???


}

