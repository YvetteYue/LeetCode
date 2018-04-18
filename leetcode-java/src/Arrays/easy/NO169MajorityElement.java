package Arrays.easy;

import java.util.Arrays;

public class NO169MajorityElement {

	public static void main(String[] args) {
		int nums[]={1,1,2};
		System.out.println(majorityElement(nums));
	}

	//beats 79.3%
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int len=nums.length;
		return nums[len/2];
	}
}
