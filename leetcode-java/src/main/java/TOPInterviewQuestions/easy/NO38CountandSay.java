package TOPInterviewQuestions.easy;

public class NO38CountandSay {

    public static void main(String[] args) {
        System.out.println(new NO38CountandSay().countAndSay2(  6));
    }

    /*
    *
     * @Date 下午5:37 2019/3/10
     * 复杂度：
     * beats：25.62;
     **/
    public String countAndSay1(int n) {
        String str="1";
        for(int i=1;i<n;i++){
            String nextRes="";
            int t=0;
            while(t<str.length()){
                int count=0;
                char tmp=str.charAt(t);
                while(t<str.length()&&str.charAt(t)==tmp) {
                    count++;
                    t++;
                }
                nextRes+=count+""+tmp;
            }
            str=nextRes;
        }
        return str;
    }


    /*
    *
     * @Date 下午5:34 2019/3/10
     * 复杂度：
     * beats：94.33%
     **/
    public String countAndSay2(int n) {
        StringBuilder nextRes=new StringBuilder();
        nextRes.append(1);
        for(int i=1;i<n;i++){
            int t=0;
            String str=nextRes.toString();
            nextRes.setLength(0);
            while(t<str.length()){
                int count=0;
                char tmp=str.charAt(t);
                while(t<str.length()&&str.charAt(t)==tmp) {
                    count++;
                    t++;
                }
                nextRes.append(count).append(tmp);
            }
        }
        return nextRes.toString();
    }
}
