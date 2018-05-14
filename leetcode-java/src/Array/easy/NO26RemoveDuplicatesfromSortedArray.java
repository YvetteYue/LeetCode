/**
 * 
 */
package Array.easy;

public class NO26RemoveDuplicatesfromSortedArray  
{

	public static void main (String[] args) 
	{
	   int[] nums = {1,2,3};
        int size=removeDuplicates3(nums);
        System.out.println(size);
        for(int i=0;i<size;i++){
            System.out.println(nums[i]);
        }
	}
	//2018/5/12 19:08 
	//22%
    public static int removeDuplicates1(int[] nums) {
        int len=nums.length;
        if(len==0)return 0;
        int start=0;
        int i=1;
        while(i<len){
            while(i<len&&nums[i]==nums[start])i++;
            if(i<len&&nums[i]!=nums[start]){
                start++;
                nums[start]=nums[i];
                i++;
            }
        }
        return start+1;
    }
    //64%
	public static int removeDuplicates2(int[] nums) {
        int len=nums.length;
        if(len==0)return 0;
        int start=0;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>pre){
                start++;
                nums[start]=nums[i];
                pre=nums[i];
            }
        }
        return start+1;
    }
    //96%
    //尽量用引用而不用数组下标运算，等于比大于貌似性能好点
	public static int removeDuplicates3(int[] nums) {
        int len=nums.length;
        if(len==0)return 0;
        int start=0;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            if(nums[i]==pre){
                continue;
            }else{
                start++;
                nums[start]=num;
                pre=num;
            }
        }
        return start+1;
    }
}