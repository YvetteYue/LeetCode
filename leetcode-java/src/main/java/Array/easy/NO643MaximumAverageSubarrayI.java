package Array.easy;

public class NO643MaximumAverageSubarrayI {
	
//	Given an array consisting of n integers, 
//	find the contiguous subarray of given length k that has the maximum average value. 
//	And you need to output the maximum average value.

	/**
	 * 
	 *2018年4月22日 下午10:23:13
	 * beats:96.87%
	 * 复杂度：
	 */
	 public double findMaxAverage(int[] nums, int k) {
	        int sum=0;
	        for(int i=0;i<k;i++){
	            sum+=nums[i];
	        }
	        int tmp=sum;
	        for(int i=k;i<nums.length;i++){
	            tmp=tmp-nums[i-k]+nums[i];
	            if(tmp>sum)sum=tmp;
	        }
	        return sum*1.0/k;
	    }
}
