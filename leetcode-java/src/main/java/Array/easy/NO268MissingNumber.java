package Array.easy;
/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * @author Yvette
 *
 */
public class NO268MissingNumber {

	public static void main(String[] args) {
		int a[]={9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber2(a));
	}

	/**
	 * 笨人方法
	 *2018年5月6日 下午6:22:19
	 * beats:26.21
	 * 复杂度：O(n)
	 */
	public static int missingNumber1(int[] nums) {
		int a = 1, b = 1;
		int len = nums.length;
		for(int i=0;i<len;i++){
			nums[i]+=1;
		}
		for (int i = 0; i < len; i++) {
			int tmp = 0;
			if (nums[i] < 0) {
				tmp = -nums[i];
			} else{
				tmp = nums[i];
			}
			if (tmp < len) {
				nums[tmp] = -nums[tmp];
			} else {
				if (tmp == len) {
					a = -1;
				} else if (tmp == len + 1) {
					b = -1;
				}
			}
		}

		for(int j=1;j<len;j++){
			if(nums[j]>0){
				return j-1;
			}
		}
		if(a==1){
			return len-1;
		}
		if(b==1){
			return len;
		}
		return 0;
	}
	
	/**
	 * 机智法：根据求和算差
	 *2018年5月6日 下午6:23:50
	 * beats:100%
	 * 复杂度：
	 */
	public static int missingNumber2(int[] nums) {
		int len=nums.length;
		int sum=(len*(len+1))/2;
		for(int i=0;i<len;i++){
			sum-=nums[i];
		}
		return sum;
	}
}
