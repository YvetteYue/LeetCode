package Array.easy;

import java.util.Arrays;

public class NO169MajorityElement {

	public static void main(String[] args) {
		int nums[]={1,1,2};
		System.out.println(majorityElement(nums));
	}

	/**
	 * 
	 *2018年4月22日 下午10:24:57
	 * beats:79.3%
	 * 复杂度：
	 */
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int len=nums.length;
		return nums[len/2];
	}
}
