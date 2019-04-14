package TOP100_Liked_Problem.easy;

public class NO198HouseRobber {

//    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
//    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
//    and it will automatically contact the police if two adjacent houses were broken into on the same night.
//    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
//    you can rob tonight without alerting the police.
//    Example 1:
//    Input: [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.
//    Example 2:
//    Input: [2,7,9,3,1]
//    Output: 12
//    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//    Total amount you can rob = 2 + 9 + 1 = 12.

    public static void main(String[] args) {
        int nums[]={10,9,2,1,3};
        System.out.println(rob(nums));
    }


    /*
    *   sum[i]=max(sum[i-1],sum[i-2]+now);
    *   dp
     * @Date 上午11:08 2019/2/12
     * 复杂度：
     * beats：89.50%
     **/
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        int sum[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int now=nums[i];
            if(i==0){
                sum[i]=nums[i];
            }else if(i==1){
                sum[i]=Math.max(nums[0],now);
            }else{
                sum[i]=Math.max(sum[i-1],sum[i-2]+now);
            }
        }
        return sum[nums.length-1];
    }

    /*
    *   res[i]=max(now+res[i-2],now+res[i-3]);
    *   max=max(res)
     * @Date 下午3:22 2019/4/14
     * 复杂度：O(n)
     * beats：100%
     **/
    public int rob3(int[] nums) {
        if(nums.length==0) return 0;
        int res[]=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            res[i]=nums[i];
            if(i==2){
                res[i]+=res[i-2];
            }else if(i>=3){
                res[i]+=Math.max(res[i-3],res[i-2]);
            }
            max=Math.max(max,res[i]);
        }
        return max;
    }

}
