/**
 * 
 */
package TOP100_Liked_Problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class NO39CombinationSum {

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    Arrays.sort(candidates);
//    dfs(candidates,new ArrayList<>(), target,target, 0);
    dfs1(list,candidates,new ArrayList<Integer>(),target, 0);
    return list;
  }
  
  /**
   *2018年7月25日 上午10:02:20
   * beats:28.68%
   * 复杂度：
   */
  static List<List<Integer>> list=new ArrayList<List<Integer>>();
  private static void dfs(int[] candidates,List<Integer> result,int target, int left,int pos) {
    if(left==0){
      list.add(result);
    }else {
      while(pos<candidates.length&&left>=candidates[pos]){
          List<Integer> tmp=new ArrayList<Integer>();
          tmp.addAll(result);
          tmp.add(candidates[pos]);
          dfs(candidates, tmp, target, left-candidates[pos], pos);
          pos++;
      }
    }
  }

  /**
   * 
   *2018年7月25日 上午10:54:53
   * beats:96.56%
   * 复杂度：
   */
  private static void dfs1(List<List<Integer>> sum,int[] candidates,List<Integer> result,int left,int pos) {
    if(left==0){
      sum.add(new ArrayList<Integer>(result));
      System.out.println(result);
    }else {
      while(pos<candidates.length&&left>=candidates[pos]){
          result.add(candidates[pos]);
          dfs1(sum, candidates, result,left-candidates[pos], pos);
          result.remove(result.size()-1);
          pos++;
      }
    }
  }
  public static void main(String[] args) {
    int[] candidates={2,3};
    int target=7;
    System.out.println(combinationSum(candidates, target));
    
  }
  
  
}
