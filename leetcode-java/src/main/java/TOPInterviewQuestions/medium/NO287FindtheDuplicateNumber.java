package TOPInterviewQuestions.medium;

public class NO287FindtheDuplicateNumber {

//    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
//    prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//        Example 1:
//    Input: [1,3,4,2,2]
//    Output: 2
//    Example 2:
//    Input: [3,1,3,4,2]
//    Output: 3
//    Note:
//    You must not modify the array (assume the array is read only).
//    You must use only constant, O(1) extra space.
//    Your runtime complexity should be less than O(n2).
//    There is only one duplicate number in the array, but it could be repeated more than once.

    public static void main(String[] args) {
        System.out.println(new NO287FindtheDuplicateNumber().findDuplicate1(new int[]{1,2,3,4,3}));
    }

    /*
    *
     * @Date 下午2:54 2019/3/10
     * 复杂度：时间o(n),空间o(n)
     * beats：100%
     **/
    public int findDuplicate1(int[] nums) {
        boolean flag[]=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(!flag[nums[i]]){
                flag[nums[i]]=true;
            }else return nums[i];
        }
        return -1;
    }

    /*
     *  类似于一个链表判断是否有环路，如果有环路，那么说明集合中有重复节点
     *  首先 nums[0]肯定和0不同，所以肯定可以通过这个点找到环路
     *  https://www.cnblogs.com/hiddenfox/p/3408931.html
     * @Date 下午2:54 2019/3/10
     * 复杂度：时间o(n),空间o(1)
     * beats：100%
     **/
    public int findDuplicate2(int[] nums) {
        int low=0;
        int fast=0;
        do{
            low=nums[low];
            fast=nums[nums[fast]];
        }while(low!=fast);  //先找到第一次遇到的位置
        fast=0;
        while(low!=fast){
            low=nums[low];
            fast=nums[fast];
        }   //从头开始 和从该位置开始一定会相遇，具体的看连接
        return low;
    }

}
