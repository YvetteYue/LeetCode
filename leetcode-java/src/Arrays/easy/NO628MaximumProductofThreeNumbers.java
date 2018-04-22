package Arrays.easy;

import java.util.Arrays;
import java.util.zip.Adler32;

public class NO628MaximumProductofThreeNumbers {

	public static void main(String[] args) {
		int nums[]={4,5,2,1,60};
		System.out.println(maximumProduct(nums));
		
	}

	
	/**
	 * 
	 *2018年4月22日 下午10:22:55
	 * beats:6.34%
	 * 复杂度：
	 */
	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int len=nums.length;
		int a1=nums[len-1];
		int a2=nums[len-2];
		int a3=nums[len-3];
		if(a1>0){
			if(a2*a3<nums[0]*nums[1])
				return a1*nums[0]*nums[1];
		}
		return nums[len-1]*nums[len-2]*nums[len-3];

	}
}
