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


    /*
    *   hash 前边遇到的字符串位置
    *   记住初始位置是pre=0
    *   第一个位置是1
    *   pre=max{当前遇到相同元素的pre字符串位置，pre} 取最大值
    *   max=max(max,当前位置-pre（即差不包括当前）)
     * @Date 上午11:21 2019/4/20
     * 复杂度：o(n)
     * beats：99.9%
     **/
    public int lengthOfLongestSubstring3(String s) {
        int pre=0;
        int max=0;
        int pos=0;
        int[] hash=new int[128];
        for(char ch:s.toCharArray()){
            pos++;
            if(hash[ch]!=0){
                pre=Math.max(hash[ch],pre);
            }
            hash[ch]=pos;
            max=Math.max(max,pos-pre);
            // System.out.println(pre);
        }
        return max;
    }
}
