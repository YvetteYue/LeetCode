package Array.easy;

public class NO747LargestNumberAtLeastTwiceofOthers {

	/**
	 * 
	 *2018年4月22日 下午10:24:07
	 * beats:15.38%
	 * 复杂度：
	 */
	public int dominantIndex(int[] nums) {
		int max = 0, index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i == index)
				continue;
			if (nums[i] * 2 > max) {
				return -1;
			}
		}
		return index;
	}
}
