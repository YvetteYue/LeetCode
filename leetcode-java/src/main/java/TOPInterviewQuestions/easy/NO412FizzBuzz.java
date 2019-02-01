package TOPInterviewQuestions.easy;

import java.util.ArrayList;
import java.util.List;

public class NO412FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz2(15));
    }

    /*
    *
     * @Date 上午11:57 2019/1/30
     * 复杂度：
     * beats：20%
     **/
    public static List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                result.add("FizzBuzz");
            }else if(i%5==0){
                result.add("Buzz");
            }else if(i%3==0){
                result.add("Fizz");
            }else result.add(i+"");
        }
        return result;
    }
    /*
     *
     * @Date 上午12:13 2019/1/30
     * 复杂度：
     * beats：91.71%
     **/
    public static List<String> fizzBuzz2(int n) {

        List<String> result=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            boolean f3=(i%3==0)?true:false;
            boolean f5=(i%5==0)?true:false;
            if(f3&&f5){
                result.add("FizzBuzz");
            }else if(f5){
                result.add("Buzz");
            }else if(f3){
                result.add("Fizz");
            }else result.add(i+"");
        }
        return result;
    }

}
