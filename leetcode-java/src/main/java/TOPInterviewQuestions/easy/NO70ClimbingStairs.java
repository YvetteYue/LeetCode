package TOPInterviewQuestions.easy;

public class NO70ClimbingStairs {


    //
    public static void main(String[] args) {
        System.out.println(climbStairs3(3));
    }

    /*
    *
     * @Date 下午4:36 2019/1/30
     * 复杂度：时间复杂度是O(2^n),空间复杂度为O(n
     * beats：8.91%
     **/
    public static int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /*
    *
     * @Date 下午4:36 2019/1/30
     * 复杂度：迭代 时间o(n) 空间o(n)
     * beats：100%
     **/
    public static int climbStairs2(int n) {
        int nums[]=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i==1){
                nums[1]=1;
            }else if(i==2){
                nums[2]=2;
            }else nums[i]=nums[i-2]+nums[i-1];
        }
        return nums[n];
    }

    /*
    *
     * @Date 下午4:45 2019/1/30
     * 复杂度：时间o(n) 空间o(1)
     * beats：100%
     **/
    public static int climbStairs3(int n) {
        int a1=1,a2=2,a3;
        if(n==1)return a1;
        if(n==2) return a2;
        for(int i=3;i<=n;i++){
            a3=a1+a2;
            a1=a2;
            a2=a3;
        }
        return a2;
    }
}
