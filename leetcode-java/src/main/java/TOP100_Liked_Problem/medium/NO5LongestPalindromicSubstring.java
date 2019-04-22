package TOP100_Liked_Problem.medium;

public class NO5LongestPalindromicSubstring {

//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//    Example 1:
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//        Example 2:
//    Input: "cbbd"
//    Output: "bb"

    public static void main(String[] args) {
        //dacae ,aa,a,aba,caaa，caaas
        System.out.println(new NO5LongestPalindromicSubstring().longestPalindrome("abcda"));
    }

    /*
    *
     * @Date 下午3:15 2019/2/13
     * 复杂度：
     * beats：49.58%
     **/
    public String longestPalindrome(String s) {
        if(s.length()==0)return s;
        char[] ch = s.toCharArray();
        int resultTimes = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < ch.length; i++) {
//            System.out.println(i);
            int time1 = 1;
            if(i>0) {
                for (int j = i - 1; j >= 0 && j <= i && i - j + i < ch.length; j--) {
//                    System.out.println(i+"单");
                    if (ch[j] == ch[i - j + i]) {
                        time1+=2;
                        if (j == 0||i-j+i==ch.length-1) {
                            if (time1 > resultTimes) {
                                begin = j;
                                end = 2 * i - j;
                                resultTimes = time1;
                                System.out.println(s.substring(begin, end + 1) + "/////1");
                                break;
                            }
                        }
                    } else {
                        if (time1 > resultTimes) {
                            begin = j + 1;
                            end = 2 * i - j-1;
                            resultTimes = time1;
                            System.out.println(s.substring(begin, end + 1) + "////2");
                        }
                        break;
                    }
                }
            }
            int time2 = 0;
            for (int j = i; j>=0&&j <= i && i - j+i + 1 < ch.length; j--) {
//                System.out.println(i+"双");
                if (ch[j] == ch[2*i-j+1]) {
                    time2+=2;
                    if(j==0||i-j+i+1==ch.length-1){
                        if (time2 > resultTimes) {
                            begin =j;
                            end=2*i-j+1;
                            resultTimes=time2;
                            System.out.println(s.substring(begin,end+1)+"////3");
                            break;
                        }
                    }
                }else {
                    if (time2 > resultTimes) {
                        begin =j+1;
                        end=2*i-j;
                        resultTimes=time2;
                        System.out.println(s.substring(begin,end+1)+"////4");
                    }
                    break;
                }
            }

        }
        return s.substring(begin,end+1);
    }

    //TODO 非最优

    /*
    *   Expand Around Center 中间扩展方式
     * @Date 上午11:56 2019/4/20
     * 复杂度：o(n^2)
     * beats：62.41%
     **/
    public String longestPalindrome2(String s) {
        if(s.length()==0)return "";
        int l=0;
        int r=0;
        int len=s.length();
        char[] chs=s.toCharArray();
        for(int i=0;i<len;i++){
            //aba类型
            int l1=i,r1=i+1;
            while(l1>=0&&r1<len&&chs[l1]==chs[r1]){
                l1--;
                r1++;
            }
            if(r1-l1>r-l){
                l=l1;
                r=r1;
            }
            //aa类型
            int l2=i-1,r2=i+1;
            while(l2>=0&&r2<len&&chs[l2]==chs[r2]){
                l2--;
                r2++;
            }
            if(r2-l2>r-l){
                l=l2;
                r=r2;
            }
        }
        return s.substring(l+1,r);
    }


    /*
    *   dp
    *   i (len-1~0) j(i~len)
    *   dp[i][j]={
    *   (1) true,i==j
    *   (2) s[i]==s[j],j=i+1
    *   (3) dp[i+1][j-1] && s[i]==s[j]
    *   }
    *
     * @Date 下午12:53 2019/4/20
     * 复杂度：o(n^2)
     * beats：38.39%
     **/
    public String longestPalindrome3(String s) {
        int len=s.length();
        if(len==0)return s;
        boolean[][] bool=new boolean[len][len];
        int l=0;
        int r=0;
        char[] chs=s.toCharArray();
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j) bool[i][j]=true;
                else if(j==i+1){
                    bool[i][j]=(chs[i]==chs[j]);
                }else{
                    bool[i][j]=(chs[i]==chs[j])&&bool[i+1][j-1];
                }
                if(bool[i][j]&&(j-i>(r-l))){
                    l=i;
                    r=j;
                }
            }
        }
        return s.substring(l,r+1);
    }


    private  int l=0;
    private  int r=0;
    /*
    *
     * @Date 下午1:59 2019/4/20
     * 复杂度：o(n)
     * beats：98%
     **/
    public String longestPalindrome4(String s) {
        int len=s.length();
        char[] chs=s.toCharArray();
        for(int i=0;i<len;i++){
            extend(chs,i,i);
            extend(chs,i,i+1);
        }
        return s.substring(l,r);
    }

    private  void extend(char[] chs,int i,int j){
        int len=chs.length;
        while(i>=0&&j<len&&chs[i]==chs[j]){
            i--;
            j++;
        }
        if(j-i>r-l+1){
            r=j;
            l=i+1;
        }
    }
}

