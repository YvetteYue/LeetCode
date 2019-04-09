package TOP100_Liked_Problem.medium;

import java.util.ArrayList;
import java.util.List;

public class NO22GenerateParentheses {

//    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//    For example, given n = 3, a solution set is:
//            [
//            "((()))",
//            "(()())",
//            "(())()",
//            "()(())",
//            "()()()"
//            ]


    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    private static List<String> list=new ArrayList<String>();
    private static char[] chs;

    /*
    *   dfs
     * @Date 下午3:15 2019/1/31
     * 复杂度：o(2^n)
     * beats：100.00%
     **/
    public static void dfs(int pos,int sum,int n,int xl,int yl){
        if(sum>n||sum<0) return;
        if(xl>n) return;
        if(yl>n) return;
        if(pos==n*2-1){
            list.add(String.valueOf(chs));
        }else {
            for(int i=0;i<2;i++){
                if(i==0) {
                    chs[pos+1]='(';
                    dfs(pos + 1, sum+1,n,xl+1,yl);
                }else {
                    chs[pos+1]=')';
                    dfs(pos + 1, sum-1,n,xl,yl+1);
                }
            }
        }
    }

    public static List<String> generateParenthesis(int n) {
        chs=new char[n*2];
        dfs(-1,0,n,0,0);
        return list;
    }


}
