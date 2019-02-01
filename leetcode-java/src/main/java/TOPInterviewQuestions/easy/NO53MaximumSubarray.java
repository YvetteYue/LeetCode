package TOPInterviewQuestions.easy;

public class NO53MaximumSubarray {

//    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//    Example:
//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.
//    Follow up:
//    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    //解题方案dp
    //    max(1,n)（max{sun[i-1]+a[i],a[i]}）
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }

    /*
    *
     * @Date 下午3:47 2019/1/30
     * 复杂度：o(n)
     * beats： 56.95%
     *
     *
     **/
    public static int maxSubArray(int[] nums) {
        int sum=nums[0];
        int presum=nums[0];
        for(int i=1;i<nums.length;i++){
            presum=(presum+nums[i]>nums[i])?presum+nums[i]:nums[i];
            if(presum>sum) sum=presum;
        }
        return sum;
    }

    /*
    *
     * @Date 下午3:47 2019/1/30
     * 复杂度：o(n)
     * beats：100%
     **/
    public static int maxSubArray2(int[] nums) {
        int sum=nums[0];
        int presum=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){
            int tmp=presum+nums[i];
            presum=(tmp>nums[i])?tmp:nums[i];
            if(presum>sum) sum=presum;
        }
        return sum;
    }
}
