package TOPInterviewQuestions.easy;

public class NO387FirstUniqueCharacterinaString {

//    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//    Examples:
//    s = "leetcode"
//            return 0.
//    s = "loveleetcode",
//            return 2.
//    Note: You may assume the string contain only lowercase letters.

    //首次出现不重复字段的位置
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));

    }

    /*
    *
     * @Date 下午2:10 2019/1/30
     * 复杂度：时间o(n),空间o(k)
     * beats：95.50%
     **/
    public static int firstUniqChar(String s) {
        char[] titles=s.toCharArray();
        int a[]=new int[26];
        int pos[]=new int[26];
        for(int i=0;i<titles.length;i++){
            int p=titles[i]-'a';
            if(a[p]==0){
                pos[p]=i;
            }
            a[p]+=1;
        }
        for(int i=0;i<titles.length;i++){
            int p=titles[i]-'a';
            if(a[p]==1){
                return pos[p];
            }
        }
        return -1;
    }
}
