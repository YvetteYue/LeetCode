package TOP100_Liked_Problem.easy;

import java.util.Arrays;

public class NO581ShortestUnsortedContinuousSubarray {

//    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
//    then the whole array will be sorted in ascending order, too.
//    You need to find the shortest such subarray and output its length.
//    Example 1:
//    Input: [2, 6, 4, 8, 10, 9, 15]
//    Output: 5
//    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//    Note:
//    Then length of the input array is in range [1, 10,000].
//    The input array may contain duplicates, so ascending order here means <=.

    public static void main(String[] args) {
        int nums[]=
                {1,2,3,4};
//                {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray2(nums));
    }

    /*
     *
     * 暴力排序做法
     * @Date 下午7:22 2019/2/9
     * 复杂度：o(nlgn)
     * beats：68.46%
     **/
    public static int findUnsortedSubarray(int[] nums) {
        int tmp[]=Arrays.copyOf(nums,nums.length);
        Arrays.sort(tmp);
        int i=0;
        int begin;
        while(i<nums.length){
            if(tmp[i]==nums[i]) i++;
            else break;
        }
        begin=i;
        i=nums.length-1;
        while(i>=0){
            if(tmp[i]==nums[i])i--;
            else break;
        }
        if(i-begin<0)return 0;
        return i-begin+1;
    }


    //TODO 简单做法
    public static int findUnsortedSubarray2(int[] nums) {
        int i=1,begin,end;
        while(i<nums.length-1){
            if(nums[i]>nums[i+1]){
                break;
            }else i++;
        }
        begin=i;
        i=nums.length-2;
        while(i>0){
            if(nums[i]<=nums[i-1]){
                break;
            }else i--;
        }
        if(i-begin<0)return 0;
        System.out.println(begin+","+i);
        return i-begin+1;
    }
}
