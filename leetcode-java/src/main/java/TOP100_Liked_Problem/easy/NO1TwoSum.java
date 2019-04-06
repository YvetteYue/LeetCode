package TOP100_Liked_Problem.easy;

import java.util.HashMap;

public class NO1TwoSum {

    //题意：求一个数组中恰好有两个数据和为target
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int[] result=new NO1TwoSum().twoSum3(nums,9);
        System.out.println(result[0]+"->"+result[1]);
    }

    /*
    *   暴力做法
     * @Date 下午4:06 2019/4/6
     * 复杂度：o(n^2)
     * beats：40%
     **/
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /*
    *   hashtable 做法 用hashmap
    *   Two-pass
     * @Date 下午4:34 2019/4/6
     * 复杂度：O(n)
     * beats：
     **/
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            //left 在，但是位置不是i说明两个数不是一个~
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }

    /*
    * one-pass hastable
     * @Date 下午4:41 2019/4/6
     * 复杂度：99.76%
     * beats：
     **/
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            //left 在，但是位置不是i说明两个数不是一个~
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
