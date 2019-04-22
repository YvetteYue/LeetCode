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
   * beats:90%
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

  /*
  *
   * @Date 下午3:41 2019/4/21
   * 复杂度：o(n)
   * beats：90%
   **/
  public String decodeString2(String s) {
    char[] pos=s.toCharArray();
    Stack<String> stack=new Stack<>();
    Stack<Integer> numStack=new Stack<>();
    int i=0;
    while(i<pos.length){
      if(pos[i]>='0'&&pos[i]<='9'){
        int num=0;
        while(pos[i]>='0'&&pos[i]<='9'){
          num=num*10+pos[i]-'0';
          i++;
        }
        numStack.push(num);
      }else if(pos[i]=='['){
        stack.push("[");
        i++;
      }else if(pos[i]==']'){
        i++;
        String str="";
        while(!stack.peek().equals("[")){
          str=stack.pop()+str;
        }
        stack.pop();
        int len=numStack.pop();
        String tmp="";
        for(int j=0;j<len;j++){
          tmp+=str;
        }
        stack.push(tmp);
      }else{
        stack.push(pos[i]+"");
        i++;
      }
    }
    String result="";
    while(!stack.isEmpty()){
      result=stack.pop()+result;
    }
    return result;
  }
  public static void main(String[] args) {
    
    System.out.println(decodeString(""));
    
  }
  
  
}
