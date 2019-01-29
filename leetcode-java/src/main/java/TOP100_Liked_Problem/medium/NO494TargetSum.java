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

  public static int num = 0;

  public static int findTargetSumWays(int[] nums, int S) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    dfs(nums, S, 0, new ArrayList<Integer>(), sum);
    return num;
  }

  /**
   * dfs
   * 2018年7月25日 上午11:38:24 
   * beats: 0%
   * 复杂度：O(2^n)
   */
  private static void dfs(int[] nums, int s, int i, List<Integer> cur, int sum) {
    if (i == nums.length) {
      if (s == 0) {
        num++;
      }
    } else {
      if(Math.abs(s)<=sum){
        for (int t = 0; t < 2; t++) {
          if (t == 0) {
            cur.add(nums[i]);
            dfs(nums, s - nums[i], i + 1, cur, sum - nums[i]);
          } else {
            cur.add(-nums[i]);
            dfs(nums, s + nums[i], i + 1, cur, sum - nums[i]);
          }
          cur.remove(cur.size() - 1);
        }
      }
    }
  }

  public static void main(String[] args) {
        
    int nums[] = {2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
    int S = 8;
    System.out.println(findTargetSumWays(nums, S));

  }


}
