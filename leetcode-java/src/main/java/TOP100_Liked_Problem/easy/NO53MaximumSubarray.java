package TOP100_Liked_Problem.easy;

public class NO53MaximumSubarray {

	/**
	 * 
	 * 如果pre+nums[i]>nums[i],pre=pre+nums[i],否则pre=nums[i]
	 * 
	 */
	public int maxSubArray(int[] nums) {
        int pre=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(pre+nums[i]>nums[i]){
                pre+=nums[i];
            }else{
                pre=nums[i];
            }
            if(max<pre){
                max=pre;
            }
        }
        return max;
    }
	
}
