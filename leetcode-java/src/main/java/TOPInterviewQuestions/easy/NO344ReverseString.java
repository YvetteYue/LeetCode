package TOPInterviewQuestions.easy;

public class NO344ReverseString {

    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString1(s);
        System.out.println(s[0]);

    }

    /*
    *
     * @Date 上午11:45 2019/1/30
     * 复杂度：时间O(n) 空间o(1)
     * beats：7.84%
     **/
    public static void reverseString1(char[] s) {
        int len=s.length;
        char tmp;
        for(int i=0;i<len/2;i++){
            tmp=s[i];
            s[i]=s[len-i-1];
            s[len-i-1]=tmp;
        }
    }

    /*
     *
     * @Date 上午11:45 2019/1/30
     * 复杂度：时间O(n) 空间o(1)
     * beats：94.54%
     **/
    public static void reverseString2(char[] s) {
        char temp;
        int start = 0;
        int end = s.length-1;

        while(start<end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
