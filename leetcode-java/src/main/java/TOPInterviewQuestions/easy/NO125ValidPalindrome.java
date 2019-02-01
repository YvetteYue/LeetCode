package TOPInterviewQuestions.easy;

public class NO125ValidPalindrome {

//    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//    Note: For the purpose of this problem, we define empty string as valid palindrome.
//            Example 1:
//    Input: "A man, a plan, a canal: Panama"
//    Output: true
//    Example 2:
//    Input: "race a car"
//    Output: false
    public static void main(String[] args) {
        System.out.println(isPalindrome("a , ;"));
    }

    /*
    *   循环条件考虑 x<y
     * @Date 下午1:59 2019/1/31
     * 复杂度：o(n)
     * beats：99.54%
     **/
    public static boolean isPalindrome(String s) {
        char[] chs=s.toCharArray();
        int x=0,y=chs.length-1;
        while(x<y){
            while(x<y&&!(chs[x]>='a'&&chs[x]<='z')&&!(chs[x]>='A'&&chs[x]<='Z')&&!(chs[x]>='0'&&chs[x]<='9')){
                x++;
            }
            while(x<y&&!(chs[y]>='a'&&chs[y]<='z')&&!(chs[y]>='A'&&chs[y]<='Z')&&!(chs[y]>='0'&&chs[y]<='9')){
                y--;
            }
            int left=chs[x],right=chs[y];
            if(chs[x]>='A'&&chs[x]<='Z'){
                left=chs[x]-'A'+'a';
            }
            if(chs[y]>='A'&&chs[y]<='Z'){
                right=chs[y]-'A'+'a';
            }
            if(left!=right){
                return false;
            }else {
                x++;
                y--;
            }
        }
        return true;
    }

}

