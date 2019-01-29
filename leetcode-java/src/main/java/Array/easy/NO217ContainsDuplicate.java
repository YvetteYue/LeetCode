package Array.easy;

import java.util.Arrays;

public class NO217ContainsDuplicate {

	public static void main(String[] args) {
		int nums[]={1,3,2,4,6};
		System.out.println(containsDuplicate(nums));
	}

	/**
	 * 
	 *2018年4月22日 下午10:20:43
	 * beats: 99.38%
	 * 复杂度：O(n)
	 */
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=1;i<nums.length;i++){
			if(nums[i-1]==nums[i]){
				return true;
			}
		}
		return false;
	}
}
