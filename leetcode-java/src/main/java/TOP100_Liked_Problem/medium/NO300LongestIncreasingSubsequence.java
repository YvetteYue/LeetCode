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


    /*
    *
     * @Date 下午4:03 2019/4/20
     * 复杂度：o(n^2)
     * beats：100%
     **/
    public int lengthOfLIS2(int[] nums) {
        int max=0;
        int len=nums.length;
        int[]result=new int[len];
        for(int i=0;i<len;i++){
            result[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    result[i]=Math.max(result[j]+1,result[i]);
                }
            }
            max=Math.max(max,result[i]);
        }
        return max;
    }

    /*
    *   dp+二分
    *   dp 数组存上升序列，循环当前数组，如果存在大于等于当前值得最大位置,插入该值
    *   https://leetcode.com/problems/longest-increasing-subsequence/solution/
     * @Date 下午5:06 2019/4/20
     * 复杂度：
     * beats：
     **/
    public int lengthOfLIS3(int[] nums) {
        int len=0;
        int[] dp=new int[nums.length];
        for(int num:nums){
            int start=0,end=len;
            while(start!=end){
                int mid=(start+end)/2;
                if(dp[mid]<num){ //[mid+1,r]
                    start=mid+1;
                }else{  //(l,mid)
                    end=mid;
                }
            }
            // System.out.println(start+"->"+dp[start]+"->"+num);
            //插入位置是小于当前的后边
            dp[start]=num;
            if(start==len){
                len++;
            }
        }
        return len;
    }
}
