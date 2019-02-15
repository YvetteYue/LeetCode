package TOP100_Liked_Problem.medium;

public class NO3LongesSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new NO3LongesSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcad"));
    }
    //TODO 需要考虑技巧，虽然题不难
    /*
    *
     * @Date 下午2:40 2019/2/15
     * 复杂度：
     * beats：94.86%
     **/
    public int lengthOfLongestSubstring(String s) {
        int tmp[]=new int[256];
        if(s.length()==0)return 0;
        int preMax=-1;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(tmp[s.charAt(i)]==0){
                tmp[s.charAt(i)]=i+1;
            }else{
                result=Math.max(result,i-preMax-1);
                preMax=Math.max(tmp[s.charAt(i)]-1,preMax);
                tmp[s.charAt(i)]=i+1;
            }
        }
        return Math.max(s.length()-1-preMax,result);
    }


    /*
    *
     * @Date 下午2:43 2019/2/15
     * 复杂度：
     * beats：97.06%
     **/
    public int lengthOfLongestSubstring2(String s) {
        int[] dict = new int[128];
        int res = 0, l = 0, r = 1;
        for(char c : s.toCharArray()) {
            l = Math.max(l, dict[c]);   // l=max(原先的，和现在的)
            dict[c] = r;
            res = Math.max(res, r++ - l);//res和当前位置-l
        }
        return res;
    }
}
