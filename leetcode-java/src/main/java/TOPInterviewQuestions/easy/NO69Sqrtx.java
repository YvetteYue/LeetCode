package TOPInterviewQuestions.easy;

public class NO69Sqrtx {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    //TODO 二分变体？
    public static int mySqrt(int x) {
        int lo=0,hi=x+1;
        while(lo<hi){
            int mi=(lo+hi)>>1;
            if(x<mi*mi){
                hi=mi;
            }else lo=mi+1;
        }
        return --lo;
    }
}
