package TOPInterviewQuestions.medium;

import java.util.ArrayList;
import java.util.List;

public class NO46Permutations {

    // TODO 有相同的数字怎么办？
//    Given a collection of distinct integers, return all possible permutations.
//            Example:
//    Input: [1,2,3]
//    Output:
//            [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//            ]

    public static void main(String[] args) {

        int num[]={1,2,3};
        System.out.println(permute2(num));
    }
//
//    /*
//    *
//     * @Date 下午3:36 2019/1/31
//     * 复杂度：
//     * beats：6.67%
//     **/
//    public static List<List<Integer>> permute(int[] nums) {
//        dfs(nums,0,nums.length);
//        return lists;
//    }
//
//    private static List<List<Integer>> lists=new ArrayList<List<Integer>>();
//    public static void dfs(int[] nums,int i,int n){
//        if(i==n-1){
//            List<Integer> tmpList=new ArrayList<Integer>();
//            for(int j=0;j<n;j++){
//                tmpList.add(nums[j]);
//            }
//            System.out.println(tmpList);
//            lists.add(tmpList);
//        }else {
//            for(int j=i;j<n;j++){
//                int tmp=nums[i];
//                nums[i]=nums[j];
//                nums[j]=tmp;
//                dfs(nums,i+1,n);
//                tmp=nums[i];
//                nums[i]=nums[j];
//                nums[j]=tmp;
//            }
//        }
//    }


    /*
    * 考虑 方面：1.可以把nums数组作为可选类型，选过了的做标记
    * 2.利用list每次新增追加
     * @Date 下午3:46 2019/1/31
     * 复杂度：
     * beats：100.00%
     **/
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        dfs2(nums,0,nums.length,new ArrayList<Integer>(),result,new boolean[nums.length]);
        return result;
    }

    public static void dfs2(int[] nums,int i,int n,List<Integer> tmpList,List<List<Integer>> result,boolean[] used){
        if(i==n){
           result.add(new ArrayList<Integer>(tmpList));
        }else {
            for(int j=0;j<n;j++){
                if(used[j])continue;
                used[j]=true;
                tmpList.add(nums[j]);
                dfs2(nums, i+1, n, tmpList, result, used);
                used[j]=false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

}
