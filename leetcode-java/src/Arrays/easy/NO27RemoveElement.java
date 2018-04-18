package Arrays.easy;

public class NO27RemoveElement {

	public static void main(String[] args) {

		int nums[]={3,3,3,2};
		int val=3;
		int len=removeElement(nums, val);
//		System.out.println(len);
		for(int i=0;i<len;i++){
			System.out.println(nums[i]);
		}
	}

	public static int removeElement(int[] nums, int val) {
		int i=0,j=nums.length-1;
		int len=nums.length;
		if(j<0)return 0;
		while(i<j&&i<len&&j>=0){
			while(i<len&&nums[i]!=val)i++;
			System.out.println(i);
			while(j>0&&nums[j]==val)j--;
			if(i<len&&j>0&&nums[i]==val&&nums[j]!=val){
				nums[i]=nums[j];
				i++;
				j--;
			}
		}
		System.out.println(i+":"+j);
		if(i>=len)return len;
		if(j<0)return 0;
		if(i==j&&nums[i]!=val)return j+1;
		return j;
	}
}
