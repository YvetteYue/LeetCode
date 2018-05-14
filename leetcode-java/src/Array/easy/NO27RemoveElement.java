/**
 * 
 */
package Array.easy;

public class NO27RemoveElement  
{
	public static void main (String[] args) 
	{
	    int[] nums={2};
	    int size=removeElement(nums,2);
	    System.out.println(size);
		for(int i=0;i<size;i++){
		    System.out.println(nums[i]);
		}

	}
	//2018/05/12 16:04
	//99%
	//注意比较临界值
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int begin=0,end=len-1;
        while(begin<end){
             if(begin<len&&nums[begin]==val&&nums[end]!=val){
                nums[begin]=nums[end];
                begin++;end--;
            }
            while(end>0&&nums[end]==val){
                end--;
            }
            while(begin<len&&nums[begin]!=val){
                begin++;
            }
        }
        
        if(begin==end){
            if(nums[begin]==val)return end;
        }
        return end+1;
    }
	
}