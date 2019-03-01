package TOPInterviewQuestions.medium;

import java.util.Stack;

public class NO150EvaluateReversePolishNotation {

//    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//            Note:
//    Division between two integers should truncate toward zero.
//    The given RPN expression is always valid.
//    That means the expression would always evaluate to a result and there won't be any divide by zero operation.
//    Example 1:
//    Input: ["2", "1", "+", "3", "*"]
//    Output: 9
//    Explanation: ((2 + 1) * 3) = 9
//    Example 2:
//    Input: ["4", "13", "5", "/", "+"]
//    Output: 6
//    Explanation: (4 + (13 / 5)) = 6
//    Example 3:
//    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//    Output: 22
//    Explanation:
//            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//            = ((10 * (6 / (12 * -11))) + 17) + 5
//            = ((10 * (6 / -132)) + 17) + 5
//            = ((10 * 0) + 17) + 5
//            = (0 + 17) + 5
//            = 17 + 5
//            = 22

    public static void main(String[] args) {
        String arr[]={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new NO150EvaluateReversePolishNotation().evalRPN(arr));
    }

    /*
    *
     * @Date 下午1:28 2019/2/24
     * 复杂度：
     * beats：90.38%
     **/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int t1=stack.pop();
                int t2=stack.pop();
                int result=0;
                switch (tokens[i]){
                    case "*":
                        result=t2*t1;
                        break;
                    case "/":
                        result=t2/t1;
                        break;
                    case "+":
                        result =t2+t1;
                        break;
                    case "-":
                        result=t2-t1;
                        break;
                }
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    //TODO 可以用数组实现
}
