package TOP100_Liked_Problem.medium;

import java.util.*;

public class NO15_3Sum {

    //求给数据中a+b+c=0的三个数字

    //数组排序，固定维度 a; b、c用双指针
    public static void main(String[] args) {
        int nums[]={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(new NO15_3Sum().threeSum1(nums));
    }


    /*
    *   暴力 ap 顺序 遇到重复的往后移动，b指针在a的后边，遇到重复的也后移
     * @Date 下午5:48 2019/4/6
     * 复杂度：O(n^2)
     * beats：37%
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        int i=0;
        while(i<nums.length){
            int tmp=-nums[i];
            int j=i+1;
            while(j<nums.length){
                int tmp1=tmp-nums[j];
                if(tmp1<nums[i]||nums[j]>tmp/2) break;
                if(map.containsKey(tmp1)&&map.get(tmp1)!=j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(tmp1);
                    result.add(list);
                }
                int pre=nums[j];
                while(j<nums.length&&pre==nums[j]) j++;
            }
            int pre2=nums[i];
            while(i<nums.length&&pre2==nums[i]){
                i++;
            }
        }
        return result;
    }


    /*
    *   固定a(保证a是不同的）, b和c用指针(如果a+b+c=0那么之后bc往中间移动到不同数字上；如果a+b+c<0那么b后移，否则c前移)
     * @Date 下午7:00 2019/4/6
     * 复杂度：O(n^2)
     * beats：96.76%
     **/
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            int start=i+1;
            int end=nums.length-1;
            int target=-nums[i];
            //两个指针
            while(start<end){
                int sum=nums[start]+nums[end];
                if(target==sum){
                    result.add(Arrays.asList(nums[start],nums[end],nums[i]));
                    int preS=nums[start];
                    while(start<end&&preS==nums[start]){
                        start++;
                    }
                    int preE=nums[end];
                    while(start<end&&preE==nums[end]){
                        end--;
                    }
                }else if(sum<target){
                    start++;
                }else end--;
            }
            int pre=nums[i];
            while(i<nums.length&&pre==nums[i]) i++;
        }
        return result;
    }

}
