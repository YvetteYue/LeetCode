package TOPInterviewQuestions.medium;

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
}
