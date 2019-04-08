package TOP100_Liked_Problem.easy;

public class NO70ClimbingStairs {

	//dp 100%
	public int climbStairs(int n) {
        int nums[]=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0) nums[i]=1;
            else if(i==1) nums[i]=1;
            else nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }
}
