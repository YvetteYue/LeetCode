package TOP100_Liked_Problem.medium;

public class NO647PalindromicSubstrings {

    public static void main(String[] args) {

    }

    /*
    *
     * @Date 下午6:28 2019/3/10
     * 复杂度：
     * beats：67.87%
     **/
    public int countSubstrings(String s) {
        char str[]=s.toCharArray();
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum++;
            int tl=i-1;
            int tr=i;
            while(tl>=0&&tr<s.length()&&str[tl]==str[tr]){
                tl--;
                tr++;
                sum++;
            }
            int tl2=i-1;
            int tr2=i+1;
            while(tl2>=0&&tr2<s.length()&&str[tl2]==str[tr2]){
                tl2--;
                tr2++;
                sum++;
            }
        }
        return sum;
    }

    //TODO 非最优
}
