package TOPInterviewQuestions.medium;

public class NO91DecodeWays {
//    A message containing letters from A-Z is being encoded to numbers using the following mapping:
//            'A' -> 1
//            'B' -> 2
//            ...
//            'Z' -> 26
//    Given a non-empty string containing only digits, determine the total number of ways to decode it.
//            Example 1:
//    Input: "12"
//    Output: 2
//    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//    Example 2:
//    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    public static void main(String[] args) {
        System.out.println(new NO91DecodeWays().numDecodings("0")); //1,2,2,2;12,2,2;12,22;1,22,2;1,2,22;
    }

    /*
    *   考虑当前字母等于0的情况
     * @Date 下午1:49 2019/2/23
     * 复杂度：
     * beats：100.00%
     **/
    public int numDecodings(String s) {
        int[] nums=new int[s.length()];
        char[] chs=s.toCharArray();
        if(chs[0]=='0') return 0;
        nums[0]=1;
        for(int i=1;i<nums.length;i++){
            int tmp=(chs[i]-'0')+(chs[i-1]-'0')*10;
            if(tmp==0)return 0;
            nums[i]=0;
            if(chs[i]!='0') {
                nums[i] = nums[i - 1];
            }
            if(tmp<=26&&chs[i-1]!='0'){
                if(i<2) nums[i]+=1;
                else nums[i]+=nums[i-2];
            }
        }
        return nums[s.length()-1];
    }
}
