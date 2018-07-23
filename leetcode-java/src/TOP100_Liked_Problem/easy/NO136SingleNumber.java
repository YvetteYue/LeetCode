/**
 * 
 */
package TOP100_Liked_Problem.easy;


/**
 * Given a non-empty array of integers, 
 * every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 每个元素出现两次，除了一个元素
 *线性时间复杂度，不需要额外空间
 */
public class NO136SingleNumber {

  
  /**
   * 位运算 a=a^b^b
   * 0=a^a
   * 0^a=a;
   *2018年7月19日 上午11:35:57
   * beats:100%
   * 复杂度：O(n)
   */
  public static int singleNumber(int[] nums) {
    int num=0;
    for(int i=0;i<nums.length;i++){
      num^=nums[i];
    }
    return num;
  }
  
  public static void main(String[] args) {
    int nums[]={2,3,2};
    System.out.println(singleNumber(nums));
  }
}
