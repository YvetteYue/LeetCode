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

/*
*
 * @Date 下午5:20 2019/4/14
 * 复杂度：O(m)
 * beats：99%
 **/
class MinStack1 {

  /** initialize your data structure here. */
  int min=Integer.MAX_VALUE;
  Stack<Integer> stack=new Stack<Integer>();
  public MinStack1() {

  }

  public void push(int x) {
    //当插入新的值时最小值改变时，插入上次旧的min
    if(x<=min){
      stack.push(min);
      min=x;
    }
    stack.push(x);
  }

  public void pop() {
    //最小值改变时，当前min为栈中的值
    if(min==stack.pop())
      min=stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}