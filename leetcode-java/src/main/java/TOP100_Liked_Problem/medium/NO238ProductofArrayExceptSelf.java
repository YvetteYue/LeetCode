package TOP100_Liked_Problem.medium;

import java.util.Arrays;
import java.util.Stack;

public class NO238ProductofArrayExceptSelf {

    /*
    *   题意：输出乘机除去本身
    *
    *   即n!/i => (1...i-1) * (i+1...n)
    *   那么可以分别算这两个，然后相乘即可
     * @Date 下午2:46 2019/4/21
     * 复杂度：o(n)
     * beats：100%
     **/
    public int[] productExceptSelf(int[] nums) {
        int[] sum=new int[nums.length];
        Arrays.fill(sum,1);
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]*nums[i-1];
        }
        int pre=1;
        for(int i=nums.length-2;i>=0;i--){
            pre=pre*nums[i+1];
            sum[i]=sum[i]*pre;
        }
        return sum;
    }
}
