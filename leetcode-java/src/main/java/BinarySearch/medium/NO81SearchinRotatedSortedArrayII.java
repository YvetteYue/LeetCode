package BinarySearch.medium;

public class NO81SearchinRotatedSortedArrayII {
//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//            (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//    You are given a target value to search. If found in the array return true, otherwise return false.
//    Example 1:
//    Input: nums = [2,5,6,0,0,1,2], target = 0
//    Output: true
//    Example 2:
//    Input: nums = [2,5,6,0,0,1,2], target = 3
//    Output: false
//    Follow up:
//    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
//    Would this affect the run-time complexity? How and why?

    //有重复的数据 仍然是o(nlgn)
    /*
    *
     * @Date 下午4:22 2019/2/14
     * 复杂度：
     * beats：100%
     **/
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int lo = 0;
        int hi = nums.length;
        while (1<hi-lo) {     //  [lo,mi)或[mi,hi) 记住！！
            int mid = (lo + hi) / 2;
            //重点！在三者都相等的情况下，无法判断在哪一边，只能缩短距离，继续二分就好了
            if( (nums[lo] == nums[hi-1]) && (nums[mid]==nums[lo]) ) {++lo; --hi;}
            else if ((nums[lo] <= nums[mid])) {
                if (target >= nums[lo] && target < nums[mid]) {       //左连续 [lo,mi)
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi-1]) {    //右连续
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            // System.out.println(lo+"->"+hi);
        }
        return nums[lo] == target ? true : false;
    }
}
