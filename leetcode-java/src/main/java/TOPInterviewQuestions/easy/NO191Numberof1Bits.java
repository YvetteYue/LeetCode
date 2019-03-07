package TOPInterviewQuestions.easy;

public class NO191Numberof1Bits {

    public static void main(String[] args) {

    }

    /*
    *
     * @Date 下午1:38 2019/3/7
     * 复杂度：
     * beats：100%
     **/
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}
