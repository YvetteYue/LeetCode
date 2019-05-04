package TOPInterviewQuestions.easy;

public class NO7ReverseInteger {

    /*
    *   注意在运算过程中要比较是否超过了int
     * @Date 下午7:36 2019/5/3
     * 复杂度：o(n)
     * beats：100%
     **/
    public int reverse(int x) {
        int y=0;
        int b1=-214748364;//-2^31
        int b2=214748364;//2^31-1

        while(x!=0){
            //printf("%d\n",y);
            if(y<b1 || y>b2)
                return 0;
            y=y*10+x%10;
            x=x/10;
        }
        return y;
    }
}
