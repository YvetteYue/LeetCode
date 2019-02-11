package TOP100_Liked_Problem.medium;

public class NO75SortColors {

//    Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
//    with the colors in the order red, white and blue.
//    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//            Note: You are not suppose to use the library's sort function for this problem.
//    Example:
//    Input: [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    Follow up:
//    A rather straight forward solution is a two-pass algorithm using counting sort.
//            First, iterate the array counting number of 0's, 1's, and 2's,
//    then overwrite array with total number of 0's, then 1's and followed by 2's.
//    Could you come up with a one-pass algorithm using only constant space?

    public static void main(String[] args) {
        int nums[]={2,0,2,1,1,0};
        sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    /*
    * count bits two pass
     * @Date 下午12:15 2019/2/11
     * 复杂度：
     * beats：100.00%
     **/
    public static void sortColors(int[] nums) {
        int num0=0,num1=0,num2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                num0++;
            }else if(nums[i]==1){
                num1++;
            }else num2++;
        }
        for(int i=0;i<num0;i++){
            nums[i]=0;
        }
        for(int i=num0;i<num0+num1;i++){
            nums[i]=1;
        }
        for(int i=num0+num1;i<num0+num2+num1;i++){
            nums[i]=2;
        }
    }


    /*
    *   TODO 一次搞定 one pass
     * @Date 下午2:29 2019/2/11
     * 复杂度：
     * beats：
     **/
    public static void sortColors2(int[] nums) {

    }

}
