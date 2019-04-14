package TOP100_Liked_Problem.easy;

import java.util.Arrays;
import java.util.Stack;

public class NO581ShortestUnsortedContinuousSubarray {

//    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
//    then the whole array will be sorted in ascending order, too.
//    You need to find the shortest such subarray and output its length.
//    Example 1:
//    Input: [2, 6, 4, 8, 10, 9, 15]
//    Output: 5
//    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//    Note:
//    Then length of the input array is in range [1, 10,000].
//    The input array may contain duplicates, so ascending order here means <=.

    public static void main(String[] args) {
        int nums[]=
                {1,2,3,4};
//                {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    /*
     *
     * 暴力排序做法
     * @Date 下午7:22 2019/2/9
     * 复杂度：o(nlgn)
     * beats：90%
     **/
    public static int findUnsortedSubarray(int[] nums) {
        int tmp[]=Arrays.copyOf(nums,nums.length);
        Arrays.sort(tmp);
        int i=0;
        int begin;
        while(i<nums.length){
            if(tmp[i]==nums[i]) i++;
            else break;
        }
        begin=i;
        i=nums.length-1;
        while(i>=0){
            if(tmp[i]==nums[i])i--;
            else break;
        }
        if(i-begin<0)return 0;
        return i-begin+1;
    }

    /*
    *   选择排序的思想
     * @Date 下午4:33 2019/4/14
     * 复杂度：o(n^2)
     * beats：5%
     **/
    public int findUnsortedSubarray2(int[] nums) {
        int len=nums.length;
        int r=0;
        int l=nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[j]<nums[i]){
                    r=Math.max(r,j);    //那么对应的最小值得最远的位置就是无序的最大位置
                    l=Math.min(l,i);    // 有比当前小的，那么当前位置开始无序
                }
            }
        }
        if(r-l<0) return 0;
        return r-l+1;
    }

    /*
    * 使用栈
     * @Date 下午5:52 2019/4/14
     * 复杂度：o(n)
     * beats：14%
     **/
    public int findUnsortedSubarray3(int[] nums) {
        Stack<Integer> stack=new Stack<Integer>();
        int l=nums.length;
        int r=0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                l=Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        //复杂度o(n)
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                r=Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r-l>0?r-l+1:0;
    }


    /*
    *   不用额外空间
     * @Date 下午6:18 2019/4/14
     * 复杂度：o(n)
     * beats：90%
     **/
    public int findUnsortedSubarray4(int[] nums) {
        int min=0;
        int i=0;
        int r=0;
        while(i<nums.length&&nums[i]>=nums[min]){
            min=i;
            i++;
        }
        while(i<nums.length){
            if(min<0){
                break;
            }
            while(min>=0&&nums[i]<nums[min]){
                min--;
            }
            i++;
        }

        int j=nums.length-1;
        int max=j;
        while(j>=0&&nums[j]<=nums[max]){
            max=j;
            j--;
        }
        while(j>=0){
            if(max>=nums.length){
                break;
            }
            while(max<nums.length&&nums[j]>nums[max]){
                max++;
            }
            j--;
        }
        if(max-min-1<0) return 0;
        return max-(min+1);
    }
    //TODO 简单做法
    public static int findUnsortedSubarray5(int[] nums) {
        int i=1,begin,end;
        while(i<nums.length-1){
            if(nums[i]>nums[i+1]){
                break;
            }else i++;
        }
        begin=i;
        i=nums.length-2;
        while(i>0){
            if(nums[i]<=nums[i-1]){
                break;
            }else i--;
        }
        if(i-begin<0)return 0;
        System.out.println(begin+","+i);
        return i-begin+1;
    }



    

    
}
