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
    public static List<String> generateParenthesis(int n) {
        chs=new char[n*2];
        dfs(-1,0,n,0,0);
        return list;
    }
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

    /*
    *
     * @Date 下午3:03 2019/4/21
     * 复杂度：o(2^n)
     * beats：97%
     **/
    public List<String> generateParenthesis2(int n) {
        List<String> list=new ArrayList<>();
        if(n==0) return list;
        dfs(list,"",n-1,n,true);
        return list;
    }

    private void dfs(List<String> result,String str,int left,int right,boolean vis){
        if(right<left) return;
        if(vis){
            str+="(";
        }else{
            str+=')';
        }
        if(left==0&&right==0){
            result.add(str);
            return;
        }
        if(left>0)
            dfs(result,str,left-1,right,true);
        if(right>0)
            dfs(result,str,left,right-1,false);
    }




}
