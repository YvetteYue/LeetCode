/**
 * 
 */
package TOP100_Liked_Problem.easy;

import java.util.Stack;

public class NO155MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
   System.out.println(minStack.top());    
   System.out.println(minStack.getMin());
  }
  
}
/**
 * 
 *2018年7月20日 上午11:13:06
 * beats:59.44%
 * 复杂度：
 */
class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minstack;
  public MinStack() {
     stack=new Stack<Integer>();
     minstack=new Stack<Integer>();
  }
  
  public void push(int x) {
    int min;
    if(stack.isEmpty()||x<minstack.peek()){
      min=x;
    }else min=minstack.peek();
    minstack.push(min);
    stack.push(x);
  }
  
  public void pop() {
    minstack.pop();
    stack.pop();
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return minstack.peek();
  }
}
