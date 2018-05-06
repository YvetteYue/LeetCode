package Arrays.easy;

import java.util.Arrays;


public class NO561ArrayPartitionI {

	public static void main(String[] args) {
		int[] nums={1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}

	/**
	 * 
	 *2018年4月22日 下午10:22:27
	 * beats:63%
	 * 复杂度：
	 */
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum=0;
		for(int i=0;i<nums.length;i+=2){
			sum+=nums[i];
		}
		return sum;
	}
}
