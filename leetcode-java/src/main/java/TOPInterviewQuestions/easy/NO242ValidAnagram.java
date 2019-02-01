package TOPInterviewQuestions.easy;

public class NO242ValidAnagram {


    public static void main(String[] args) {
        System.out.println(isAnagram("anagram",  "nagaram"));
    }

    /*
    *
     * @Date 下午3:23 2019/1/30
     * 复杂度：o(n)
     * beats：98.2%
     **/
    public static boolean isAnagram(String s, String t) {
        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        int[] sc=new int[26];
        int[] tc=new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<schar.length;i++){
            sc[schar[i]-'a']+=1;
            tc[tchar[i]-'a']+=1;
        }
        for(int i=0;i<26;i++){
            if(sc[i]!=tc[i]){
                return false;
            }
        }
        return true;
    }
}
