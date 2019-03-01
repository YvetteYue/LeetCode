package Array.easy;

import java.util.*;

public class NO349IntersectionofTwoArrays {

//    Given two arrays, write a function to compute their intersection.
//            Example 1:
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
//    Note:
//    Each element in the result should appear as many times as it shows in both arrays.
//    The result can be in any order.
//    Follow up:
//    What if the given array is already sorted? How would you optimize your algorithm?
//    What if nums1's size is small compared to nums2's size? Which algorithm is better?
//    What if elements of nums2 are stored on disk, and the memory is limited such that
//    you cannot load all elements into the memory at once?

    public static void main(String[] args) {

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++){
            int res=Arrays.binarySearch(nums1,nums2[i]);
            if(res>=0) {
                set.add(nums2[i]);
            }
        }
        int tmp[]=new int[set.size()];
        int pos=0;
        for(Integer num:set){
            tmp[pos]=num;
            pos++;
        }
        return tmp;
    }

    //TODO 非最优 需要用hash 和two point
}
