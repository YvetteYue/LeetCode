package TOPInterviewQuestions.easy;

public class NO171ExcelSheetColumnNumber {
//
//    Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//    For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    /*
    *
     * @Date 下午1:00 2019/1/30
     * 复杂度：o(n)
     * beats：100%
     **/
    //26进制转10进制
    public static int titleToNumber(String s) {
        char[] titles=s.toCharArray();
        int sum=0;
        for(int i=0;i<titles.length;i++){
            sum=sum*26+(titles[i]-'A'+1);
        }
        return sum;
    }
}
