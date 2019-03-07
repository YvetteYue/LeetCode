package TOP100_Liked_Problem.medium;

public class NO55JumpGame {

    public static void main(String[] args) {
        int nums[]={2};
        System.out.println(new NO55JumpGame().canJump(nums));
    }

    /*
    *   贪心的思路 每次选择跳到（pos+step）>pre的pos位置，能跳出，说明true
     * @Date 上午12:16 2019/3/4
     * 复杂度：
     * beats：92.80%
     **/
    public boolean canJump(int[] nums) {
        int pos=0;
        int step=nums[0];
        while(pos<nums.length-1){
//            System.out.println(pos+"->"+step);
            int pre=step;
            int tmpPos=pos;
            if(pos+step>=nums.length-1)return true;
            for(int i=pos;i<=pos+step;i++){
                if(nums[i]+i-pos>=pre){
                    pre=nums[i]+i-pos;
                    tmpPos=i;
                }
            }
            pos=tmpPos;
            step=nums[pos];
//            System.out.println(pos+"-->"+(pos+step));
            if(step==0) return false;
        }
        return true;
    }
}
