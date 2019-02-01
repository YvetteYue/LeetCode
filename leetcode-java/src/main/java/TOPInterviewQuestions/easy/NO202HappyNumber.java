package TOPInterviewQuestions.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO 非最佳
public class NO202HappyNumber {
//    Write an algorithm to determine if a number is "happy".
//    A happy number is a number defined by the following process:
//    Starting with any positive integer, replace the number by the sum of the squares of its digits,
//    and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//    Those numbers for which this process ends in 1 are happy numbers.
//        Example:
//    Input: 19
//    Output: true
//    Explanation:
//            1^2 + 9^2 = 82
//            8^2 + 2^2 = 68
//            6^2 + 8^2 = 100
//            1^2 + 0^2 + 0^2 = 1

    //isHappy 代表结果能为1，notHappy代表无止境的循环且不为1
    public static void main(String[] args) {
        System.out.println(isHappy(19));

    }


    /*
    *
     * @Date 下午2:44 2019/1/30
     * 复杂度：o(n^2)
     * beats：8.25%
     **/
    public static boolean isHappy(int n) {
        Set<Integer> hash=new HashSet<Integer>();
        while(true){
            List<Integer> list=split(n);
            int sum=0;
            for(Integer num:list){
                sum+=num*num;
            }
            if(sum==1){
                return true;
            }else if(hash.contains(sum)){
                return false;
            }else hash.add(sum);
            n=sum;
        }
    }

    private static List<Integer> split(int n){
        List<Integer> tmp=new ArrayList<Integer>();
        while(n/10!=0){
            tmp.add(n%10);
            n=n/10;
        }
        tmp.add(n);
        return tmp;
    }
}
