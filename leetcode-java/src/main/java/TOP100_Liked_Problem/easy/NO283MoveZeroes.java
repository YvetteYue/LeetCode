package TOP100_Liked_Problem.easy;

public class NO283MoveZeroes {

	// Given an array nums, write a function to move all 0's to the end of it
	// while maintaining the relative order of the non-zero elements.
	// For example, given nums = [0, 1, 0, 3, 12], after calling your function,
	// nums should be [1, 3, 12, 0, 0].

	// You must do this in-place without making a copy of the array.
	// Minimize the total number of operations.
	public static void main(String[] args) {
		int nums[] = { 1, 1, 0, 0, 12 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	/**
	 * 
	 *2018年4月22日 下午10:21:27
	 * beats:17%
	 * 复杂度：
	 */
	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		int len=nums.length;
		while (i<len&&nums[i] != 0) {
			i++;
			j++;
		}
			while (i<len&&j<len&&nums[i] == 0) {
				while(j<len&&nums[j]==0){
					j++;
				}
				if(j<len){
					nums[i]=nums[j];
					nums[j]=0;
					j++;
					i++;
				}
				while(i<len&&nums[i]!=0){
					i++;
				}
		}
	}


	/*
	*
	 * @Date 下午12:13 2019/4/14
	 * 复杂度：o(n)
	 * beats：100%
	 **/
	public void moveZeroes2(int[] nums) {
		int i=0;
		int j=0;
		while(i<nums.length){
			if(nums[i]!=0&&i==j){
				i++;
				j++;
			}else if(nums[i]!=0){
				nums[j]=nums[i];
				nums[i]=0;
				i++;
				j++;
			}else {
				i++;
			}
		}
	}

}
