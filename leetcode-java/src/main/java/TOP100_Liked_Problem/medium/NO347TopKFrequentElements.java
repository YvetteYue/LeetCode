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
        System.out.println(new NO347TopKFrequentElements().topKFrequent3(nums, 2));
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


    /*
    *   hashmap+heap
     * @Date 下午10:11 2019/5/5
     * 复杂度：o(nlgn)
     * beats：98%
     **/
    public List<Integer> topKFrequent3(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        HeapEntry[] heap=new HeapEntry[map.size()];
        int i=0;
        for(int entry:map.keySet()){
            heap[i]=new HeapEntry(entry,map.get(entry));
            i++;
        }
        int len=heap.length;
        for(int j=len/2-1;j>=0;j--){
            heapAdjust(heap,len,j);
        }
        for(int j=0;j<k;j++){
            list.add(heap[0].key);
            heap[0]=heap[len-1];
            len--;
            heapAdjust(heap,len,0);
        }
        return list;

    }

    private void heapAdjust(HeapEntry[] heap,int len,int pos){
        HeapEntry tmp=heap[pos];
        for(int i=pos*2+1;i<len;i=i*2+1){
            if(i+1<len&&heap[i].freq<heap[i+1].freq){
                i++;
            }
            if(heap[i].freq>tmp.freq){
                heap[pos]=heap[i];
                pos=i;
            }else{
                break;
            }
        }
        heap[pos]=tmp;
    }
    class HeapEntry{
        int key;
        int freq;
        HeapEntry(int key,int freq){
            this.key=key;
            this.freq=freq;
        }
    }


}

