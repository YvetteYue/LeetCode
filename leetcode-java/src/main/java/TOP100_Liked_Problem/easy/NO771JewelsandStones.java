package TOP100_Liked_Problem.easy;

import java.util.HashMap;
import java.util.HashSet;

public class NO771JewelsandStones {

//    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
//    Each character in S is a type of stone you have.
//    You want to know how many of the stones you have are also jewels.
//    The letters in J are guaranteed distinct, and all characters in J and S are letters.
//    Letters are case sensitive, so "a" is considered a different type of stone from "A".
//    Example 1:
//    Input: J = "aA", S = "aAAbbbb"
//    Output: 3
//    Example 2:
//    Input: J = "z", S = "ZZ"
//    Output: 0
//    Note:
//    S and J will consist of letters and have length at most 50.
//    The characters in J are distinct.

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("a","AAbbbb"));
    }


    /*
    *   用字符串hash
     * @Date 下午5:22 2019/2/8
     * 复杂度：
     * beats：76.11%
     **/
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> chSets=new HashSet<Character>();
        for(char ch:J.toCharArray()){
            chSets.add(ch);
        }
        int sum=0;
        for(char ch:S.toCharArray()){
            if(chSets.contains(ch)){
                sum++;
            }
        }
        return sum;
    }

    /*
    * 用数组hash  前128个为字母啥的
     * @Date 下午5:29 2019/2/8
     * 复杂度：
     * beats：99.78%
     **/
    public static int numJewelsInStones1(String J,String S){
        if(J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        boolean[] jewel = new boolean[128];
        for(char c : J.toCharArray())
            jewel[c] = true;
        int res = 0;
        for(char c : S.toCharArray()) {
            if(jewel[c]) ++res;
        }
        return res;
    }


}
