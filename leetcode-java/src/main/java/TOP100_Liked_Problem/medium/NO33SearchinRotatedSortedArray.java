package TOP100_Liked_Problem.medium;

import java.util.Arrays;

public class NO33SearchinRotatedSortedArray {

//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//            (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//    You may assume no duplicate exists in the array.
//    Your algorithm's runtime complexity must be in the order of O(log n).
//    Example 1:
//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//    Example 2:
//    Input: nums = [4,5,6,7,0,1,2], target = 3
//    Output: -1

    public static void main(String[] args) {
        int nums[]={4,7,1,2};
        System.out.println(new NO33SearchinRotatedSortedArray().search(nums,3));
    }

    /*
    *   TODO 二分改进
     * @Date 下午3:19 2019/2/14
     * 复杂度：
     * beats：95.56%
     **/
    public int search(int[] A, int target) {
        if(A.length==0) return -1;
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }

    /*
    *   根据原始二分算法改变
     * @Date 下午3:48 2019/2/14
     * 复杂度：
     * beats：
     **/
    public int search2(int[] A, int target) {
        if(A.length==0) return -1;
        int lo = 0;
        int hi = A.length;
        while (1<hi-lo) {     //  [lo,mi)或[mi,hi) 记住！！
            int mid = (lo + hi) / 2;
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {       //左连续
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (target >= A[mid] && target <= A[hi-1]) {    //右连续
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }


}
