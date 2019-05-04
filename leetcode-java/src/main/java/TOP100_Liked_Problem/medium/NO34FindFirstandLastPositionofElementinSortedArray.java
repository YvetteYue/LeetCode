package TOP100_Liked_Problem.medium;

public class NO34FindFirstandLastPositionofElementinSortedArray {

//    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//    Your algorithm's runtime complexity must be in the order of O(log n).
//    If the target is not found in the array, return [-1, -1].
//    Example 1:
//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//    Example 2:
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]

    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
        int [] result=new NO34FindFirstandLastPositionofElementinSortedArray().searchRange(nums,11);
        System.out.println(result[0]+","+result[1]);
    }

    /*
    *
     * @Date 下午3:55 2019/2/16
     * 复杂度：
     * beats：100%
     **/
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        result[0]=-1;
        result[1]=-1;
        if(nums.length==0) return result;
        int left=binarysearch(nums,target-1,0,nums.length);
        int right=binarysearch(nums,target,0,nums.length);
        if(right>=0&&nums[right]!=target){
            result[1]=-1;
        }else result[1]=right;
        if(left+1<=nums.length-1&&nums[left+1]==target){
            result[0]=left+1;
        }
        return result;
    }

    public int binarysearch(int[] nums,int target,int lo,int hi){
        while(lo<hi){
            int mi=(lo+hi)>>1;
            if(target<nums[mi]){//[lo,mi) 或（mi,hi）
                hi=mi;
            }else lo=mi+1;
        }//出口时，A[lo=hi] 为不大于e的最大元素
        return --lo;
    }


    /*
    *
     * @Date 下午5:04 2019/5/1
     * 复杂度：o(lgn)
     * beats：100%
     **/
    public int[] searchRange2(int[] nums, int target) {
        int pos1=search1(nums,0,nums.length-1,target);
        int pos2=search2(nums,0,nums.length-1,target);
        return new int[]{pos1,pos2};
    }

    //first
    private int search1(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(left<nums.length&&left>=0&&nums[left]==target){
            return left;
        }
        return -1;
    }

    //last
    private int search2(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(right>=0&&right<nums.length&&nums[right]==target){
            return right;
        }
        return -1;
    }
}
