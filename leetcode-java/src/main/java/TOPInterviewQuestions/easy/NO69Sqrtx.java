package TOPInterviewQuestions.easy;

public class NO69Sqrtx {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    /*
    *   两个优化：1.hi=x/2+1 为了方式h过大在/2的时候超过
    *   2.x/mi<mi 为了防止mi*mi超过int变成负数
     * @Date 下午10:04 2019/3/10
     * 复杂度：
     * beats：99.97%
     **/
    public static int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1)return 1;
        int lo=1,hi=x/2+1;
        while(lo<hi){
            int mi=(lo+hi)>>1;
            if(x/mi<mi){   // [lo,mi)
                hi=mi;
            }else lo=mi+1;  //(mi,hi]
        }
        return --lo;
    }
}
