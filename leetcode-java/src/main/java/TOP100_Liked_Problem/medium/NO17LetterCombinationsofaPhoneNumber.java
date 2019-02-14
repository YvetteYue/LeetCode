package TOP100_Liked_Problem.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NO17LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new NO17LetterCombinationsofaPhoneNumber().letterCombinations2("23"));
    }

    /*
    *   队列
     * @Date 下午2:27 2019/2/14
     * 复杂度：
     * beats：80.24%
     **/
    public List<String> letterCombinations(String digits) {
        Queue<String> queue=new LinkedList<>();
        List<String> result=new ArrayList<>();
        char[] origins=digits.toCharArray();
        char[][] number={
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        int pos=0;
        while(pos<digits.length()){
            if(pos==0){
                int tmp=origins[pos]-'2';
                for(int i=0;i<number[tmp].length;i++){
                    queue.add(""+number[tmp][i]);
                }
            }else{
                int size=queue.size();
                for(int i=0;i<size;i++){
                    String ori=queue.poll();
                    int tmp=origins[pos]-'2';
                    for(int j=0;j<number[tmp].length;j++){
                        queue.add(ori+number[tmp][j]);
                    }
                }
            }
            pos++;
        }
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }

    char[][] number={
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    private List<String> result=new ArrayList<>();
    /*
    *
     * @Date 下午2:40 2019/2/14
     * 复杂度：
     * beats：100%
     **/
    public List<String> letterCombinations2(String digits) {
        if(digits.length()==0) return result;
        dfs(digits,digits.length(),0,"");
        return result;
    }

    private void dfs(String digits,int n,int pos,String now){
        if(n==pos){
            result.add(now);
            return;
        }else {
            for(int i=0;i<number[digits.charAt(pos)-'2'].length;i++){
                dfs(digits,n,pos+1,now+number[digits.charAt(pos)-'2'][i]);
            }
        }
    }
}
