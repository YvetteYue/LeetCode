package TOP100_Liked_Problem.medium;

public class NO338CountingBits {

//    Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
//    Example 1:
//    Input: 2
//    Output: [0,1,1]
//    Example 2:
//    Input: 5
//    Output: [0,1,1,2,1,2]
//    Follow up:
//    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
//    Space complexity should be O(n).
//    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

    public static void main(String[] args) {
        int nums[]=new NO338CountingBits().countBits(5);
        for(int i:nums){
            System.out.println(i);
        }
    }

    /*
    *
     * @Date 下午5:43 2019/3/7
     * 复杂度：
     * beats：99.97%
     **/
    public int[] countBits(int num) {
        int result[]=new int[num+1];
        for(int i=0;i<=num;i++){
            if(i==0)result[0]=0;
            else if(i==1)result[1]=1;
            else{
                result[i]=result[i>>1]+(i&1);
            }
        }
        return result;
    }

}
