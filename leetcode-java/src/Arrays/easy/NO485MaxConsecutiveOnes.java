package Arrays.easy;

public class NO485MaxConsecutiveOnes {

	//Given a binary array, find the maximum number of consecutive 1s in this array.
	public static void main(String[] args) {
		int[] num={1,1,0,0,1,1,1};
		
		System.out.println(findMaxConsecutiveOnes(num));
	}

	//beats 99.7%
	public static int findMaxConsecutiveOnes(int[] nums) {
		int len=nums.length;
		int i=0;
		int res=0;
		while(i<len){
			int tmp=0;
			while(i<len&&nums[i]==1){
				tmp++;
				i++;
			}
			if(res<tmp) res=tmp;
			while(i<len&&nums[i]==0){
				i++;
			}
		}
		return res;

	}
}
