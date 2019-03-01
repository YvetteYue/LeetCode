package TOP100_Liked_Problem.medium;

public class NO300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new NO300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }


    /*
    *   dp[i]=Max(nums[j]<nums[i]|0~i-1){dp[j]+1)}
     * @Date 下午6:04 2019/2/24
     * 复杂度：
     * beats：
     **/
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int dp[] = new int[nums.length];
        int MaxNum = 1;
        dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            MaxNum = Math.max(dp[i], MaxNum);
        }
        return MaxNum;
    }


    //TODO dp+二分
}
