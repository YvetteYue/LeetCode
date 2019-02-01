package TOPInterviewQuestions.medium;

import java.util.Random;
// 所谓洗牌算法，就是给你一个1到n的序列，让你随机打乱，保证每个数出现在任意一个位置的概率相同，也就是说在n!个的排列中，每一个排列出现的概率相同。
//最简单的方式是随机排列，每种排列的可能是1/n!，每张牌出现的概率是1/n
//TODO 洗牌算法
//https://blog.csdn.net/shenwansangz/article/details/50888152

//朴素版：求全排列，全排列中随机选择
//经典算法： 取0-当前内随机选择最为当前位置的数字。
public class NO384ShuffleanArray {

    public static void main(String[] args) {
        int nums[]={1,2,3};
        Solution solution=new Solution(nums);
        solution.shuffle();
        solution.reset();
    }


}

/*
*
 * @Date 下午2:32 2019/2/1
 * 复杂度：
 * beats：33.13%
 **/
class Solution {

    private int[] oriNums;
    private Random random;
    public Solution(int[] nums) {
        oriNums=nums;
        random=new Random();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return oriNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] num=oriNums.clone();
        for(int i=1;i<num.length;i++){
            int k=random.nextInt(i+1);
            swap(num,k,i);
        }
        return num;
    }
    private void swap(int[] num,int k,int i){
        int tmp=num[k];
        num[k]=num[i];
        num[i]=tmp;
    }

}

/*
*
 * @Date 下午2:31 2019/2/1
 * 复杂度：
 * beats：93.13%
 **/
class Solution2 {

    private int[] nums;
    public Solution2(int[] nums) {
        this.nums=nums;

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }
}