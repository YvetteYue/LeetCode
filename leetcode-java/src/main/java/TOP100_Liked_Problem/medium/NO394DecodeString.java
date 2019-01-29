/**
 * 
 */
package TOP100_Liked_Problem.medium;

import java.util.Stack;

/**
 * @author Administrator
 *
 */
public class NO394DecodeString {

  
  
  /**
   * 
   *2018年7月24日 下午6:28:27
   * beats:98.86%
   * 复杂度：
   */
  public static String decodeString(String s) {
    Stack<String> strStack=new Stack<String>();
    Stack<Integer> timesStack=new Stack<Integer>();
    int i=0;
    char[] ch=s.toCharArray();
    while(i<s.length()){
      if(ch[i]<='9'&&ch[i]>='0'){
        int num=0;
        while(i<s.length()&&ch[i]<='9'&&ch[i]>='0'){
          num=num*10+(ch[i]-'0');
          i++;
        }
        timesStack.push(num);
      }else if(ch[i]=='['){
        strStack.push("[");
        i++;
        continue;
      }else if(ch[i]==']'){
        i++;
        String str;
        String tmp="";
        while(!(str=strStack.pop()).equals("[")){
          tmp=str+tmp;
        }
        StringBuilder stringBuilder=new StringBuilder();
        int times=timesStack.pop();
        for(int j=0;j<times;j++){
          stringBuilder.append(tmp);
        }
        strStack.push(stringBuilder.toString());
      }else {
        StringBuilder stringBuilder=new StringBuilder();
        while(i<s.length()&&ch[i]!=']'&&ch[i]!='['&&(ch[i]<'0'||ch[i]>'9')){
          stringBuilder.append(ch[i]);
          i++;
        }
        strStack.push(stringBuilder.toString());
      }
    }
    StringBuilder result=new StringBuilder();
    while(!strStack.isEmpty()){
      result.insert(0,strStack.pop());
    }
    return result.toString();
  }

  
  public static void main(String[] args) {
    
    System.out.println(decodeString(""));
    
  }
  
  
}
