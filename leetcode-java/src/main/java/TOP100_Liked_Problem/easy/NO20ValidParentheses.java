/**
 * 
 */
package TOP100_Liked_Problem.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order.
 * 
 * @author Administrator
 *
 */
public class NO20ValidParentheses {


  public static void main(String[] args) {
    System.out.println(isValid("()"));
  }


  /**
   * String版慢 
   * 2018年7月23日 下午5:35:29 
   * beats: 
   * 复杂度：3.94%
   */
  public static boolean isValid1(String s) {
    Stack<String> stack = new Stack<String>();
    if (s.length() == 0)
      return true;
    String[] strings = s.split("");
    int i = 0;
    while (i < strings.length) {
      if (strings[i].equals("{") || strings[i].equals("(") || strings[i].equals("[")) {
        stack.push(strings[i]);
        i++;
      } else {
        if (strings[i].equals("}")) {
          if (!stack.isEmpty() && stack.peek().equals("{")) {
            stack.pop();
            i++;
          } else
            return false;
        } else if (strings[i].equals(")")) {
          if (!stack.isEmpty() && stack.peek().equals("(")) {
            stack.pop();
            i++;
          } else
            return false;
        } else if (strings[i].equals("]")) {
          if (!stack.isEmpty() && stack.peek().equals("[")) {
            stack.pop();
            i++;
          } else
            return false;
        } else
          return false;
      }
    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * char 
   * 2018年7月23日 下午5:44:38 
   * beats:95.25% 
   * 复杂度：
   */
  public static boolean isValid2(String s) {
    Stack<Character> stack = new Stack<Character>();
    if (s.length() == 0)
      return true;
    int i = 0;
    char[] strings = s.toCharArray();
    while (i < strings.length) {
      if (strings[i] == '{' || strings[i] == '(' || strings[i] == '[') {
        stack.push(strings[i]);
        i++;
      } else {
        if (strings[i] == '}') {
          if (!stack.isEmpty() && stack.peek().equals('{')) {
            stack.pop();
            i++;
          } else
            return false;
        } else if (strings[i] == ')') {
          if (!stack.isEmpty() && stack.peek().equals('(')) {
            stack.pop();
            i++;
          } else
            return false;
        } else if (strings[i] == ']') {
          if (!stack.isEmpty() && stack.peek().equals('[')) {
            stack.pop();
            i++;
          } else
            return false;
        } else
          return false;
      }
    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * 
   *2018年7月23日 下午6:01:51
   * beats:38.17%
   * 复杂度：
   */
  public static boolean isValid3(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char ch : s.toCharArray()) {
      if (ch == '}' || ch == ']' || ch == ')') {
        if (stack.isEmpty())
          return false;
        char top = stack.pop();
        switch (top) {
          case '(':
            if(ch!=')')return false;
            break;
          case '{':
            if(ch!='}')return false;
            break;
          case '[':
            if(ch!=']')return false;
            break;
          default:
            break;
        }
      } else
        stack.push(ch);
    }
    return stack.isEmpty();
  }
  
  /**
   * 不用栈，使用数组
   *2018年7月23日 下午6:02:29
   * beats:
   * 复杂度：
   */
  public static boolean isValid(String s) {
    
    return false;
  }
}
