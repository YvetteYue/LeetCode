package TOP100_Liked_Problem.medium;

public class NO152MaximumProductSubarray {

    public static void main(String[] args) {

    }

    /*
    *   一个是目前最大值，一个是目前最小值
    *   dp[i]=max(dp[i-1]*nums[i],nums[i])
     * @Date 下午4:03 2019/5/1
     * 复杂度：o(n)
     * beats：98%
     **/
    public int maxProduct(int[] nums) {
        int result=Integer.MIN_VALUE;
        int minsofar=0;
        int maxsofar=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                minsofar=nums[0];
                maxsofar=nums[0];
            }else{
                if(nums[i]>=0){
                    maxsofar=Math.max(maxsofar*nums[i],nums[i]);
                    minsofar=Math.min(minsofar*nums[i],nums[i]);
                }else{
                    int tmp=maxsofar;
                    maxsofar=Math.max(minsofar*nums[i],nums[i]);
                    minsofar=Math.min(tmp*nums[i],nums[i]);
                }

            }
            result=Math.max(maxsofar,result);
        }
        return result;
    }


}
