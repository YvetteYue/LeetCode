package TOPInterviewQuestions.easy;

public class NO14LongestCommonPrefix {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string "".
//    Example 1:
//    Input: ["flower","flow","flight"]
//    Output: "fl"
//    Example 2:
//    Input: ["dog","racecar","car"]
//    Output: ""
//    Explanation: There is no common prefix among the input strings.
//            Note:
//    All given inputs are in lowercase letters a-z.

    public static void main(String[] args) {
        String strs[]={"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    /*
    *
     * @Date 下午2:17 2019/1/31
     * 复杂度：o(n*m)
     * beats：100.00%
     **/
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int maxlen=strs[0].length();
        int strslen=strs.length;
        int tmp=0;
        for(int i=1;i<strslen;i++){
            if(maxlen>strs[i].length()){
                maxlen=strs[i].length();
                tmp=i;
            }
        }

        for(int i=0;i<maxlen;i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strslen;j++){
                if(ch!=strs[j].charAt(i)){
                    return strs[j].substring(0,i);
                }
            }
        }
        return strs[tmp];
    }

}
