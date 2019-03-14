package TOPInterviewQuestions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NO350IntersectionofTwoArraysII {

    public static void main(String[] args) {
        int nums1[]={1,2,2,1};
        int nums2[]={2,2};
        System.out.println(new NO350IntersectionofTwoArraysII().intersect(nums1,nums2));
    }

    /*
    *
     * hashmap 的解决办法
     * @Date 下午9:12 2019/3/10
     * 复杂度：
     * beats：93.95%
     **/
    public int[] intersect(int[] nums1, int[] nums2) {
        int result[]=new int[nums2.length];
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hash.put(nums1[i],hash.getOrDefault(nums1[i],0)+1);
        }
        int pos=0;
        for(int i=0;i<nums2.length;i++){
            if(hash.containsKey(nums2[i])){
                int tmp=hash.get(nums2[i])-1;
                hash.put(nums2[i],tmp);
                if(tmp==0) hash.remove(nums2[i]);
                result[pos]=nums2[i];
                pos++;
            }
        }
        return Arrays.copyOf(result,pos);

    }

    /*
    *
     * @Date 下午9:15 2019/3/10
     * 复杂度：
     * beats：100%
     **/
    public int[] intersect2(int[] nums1, int[] nums2) {
        int result[]=new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        int pos=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                result[pos]=nums1[i];
                i++;
                j++;
                pos++;
            }
            while(i<nums1.length&&j<nums2.length&&nums1[i]<nums2[j]) i++;
            while(i<nums1.length&&j<nums2.length&&nums1[i]>nums2[j]) j++;
        }
        return Arrays.copyOf(result,pos);
    }

    //https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82281/Two-C%2B%2B-solutions%3A-hashtable-and-sort%2Bbinary-search.-Time-and-space-complexity-analyzed.
    //TODO 二分查找做法
}
