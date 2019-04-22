/**
 * 
 */
package TOP100_Liked_Problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * 可使用dfs，dp(最佳)
 */
public class NO494TargetSum {

  /*
  *
   * @Date 下午2:28 2019/4/21
   * 复杂度：O(2^n)
   * beats：22%
   **/
  public int findTargetSumWays(int[] nums, int S) {
    dfs(nums,S,0,0);
    return count;
  }

  private int count=0;
  private void dfs(int[] nums,int S,int num,int pos){
    if(pos==nums.length){
      if(S==num)
        count++;
      return;
    }else{
      dfs(nums,S,num+nums[pos],pos+1);
      dfs(nums,S,num-nums[pos],pos+1);
    }
  }

  public static void main(String[] args) {
        
    int nums[] = {2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
    int S = 8;
    System.out.println(new NO494TargetSum().findTargetSumWays(nums, S));

  }


}
