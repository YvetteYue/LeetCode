package TOP100_Liked_Problem.medium;

import java.util.ArrayList;
import java.util.List;

public class NO78Subsets {

//    Given a set of distinct integers, nums, return all possible subsets (the power set).
//    Note: The solution set must not contain duplicate subsets.
//    Example:
//    Input: nums = [1,2,3]
//    Output:
//            [
//            [3],
//            [1],
//            [2],
//            [1,2,3],
//            [1,3],
//            [2,3],
//            [1,2],
//            []
//            ]
    public static void main(String[] args) {
        int num[]={1,2,3};
        System.out.println(subsets(num));
    }

    /*
    *
     * @Date 下午4:30 2019/1/31
     * 复杂度：
     * beats： 100.00%
     **/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        dfs(nums,list,new ArrayList<Integer>(),nums.length,0);
        return  list;
    }

    public static void dfs(int[] nums,List<List<Integer>> result,List<Integer> tmpList,int n,int i){
       if(i==n){
            result.add(new ArrayList<Integer>(tmpList));
       } else {
                dfs(nums,result,tmpList,n,i+1);
                   tmpList.add(nums[i]);
                   dfs(nums, result, tmpList, n, i + 1);
                   tmpList.remove(tmpList.size() - 1);

       }


    }

}
