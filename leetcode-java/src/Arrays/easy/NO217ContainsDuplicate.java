package Arrays.easy;

import java.util.Arrays;

public class NO217ContainsDuplicate {

	public static void main(String[] args) {
		int nums[]={1,3,2,4,6};
		System.out.println(containsDuplicate(nums));
	}

	//beats 99.38%
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
