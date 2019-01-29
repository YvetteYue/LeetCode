/**
 * 
 */
package Array.easy;

public class NO189RotateArray 
{

	public static void main (String[] args) 
	{
	   int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 7);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
	}
	//98%方法1
	public static void rotate(int[] nums, int k) {
        int len=nums.length;
        if(k==len||k==0)return;
        if(k>len)k=k%len;
        int[] knums=new int[k];
        for(int i=len-k;i<len;i++){
            knums[i-len+k]=nums[i];
        }
        for(int i=len-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=knums[i];
        }
    }
}