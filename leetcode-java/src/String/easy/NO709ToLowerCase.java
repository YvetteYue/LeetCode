/**
 * 
 */
package String.easy;

/**
 * @author Administrator
 *
 */
public class NO709ToLowerCase {

  /**
   * 
   *2018年7月18日 下午5:22:23
   * beats:4.9%
   * 复杂度：
   */
  public static String toLowerCase1(String str) {
    return str.toLowerCase();
  }
  
  /**
   * 
   *2018年7月18日 下午5:22:45
   * beats:100%
   * 复杂度：
   */
  public static String toLowerCase2(String str) {
    char[] chars=str.toCharArray();
    for(int i=0;i<chars.length;i++){
      if(chars[i]>='A'&&chars[i]<='Z'){
        chars[i]=(char) (chars[i]-'A'+'a');
      }
    }
    return String.valueOf(chars);
  }
  public static void main(String[] args) {
    System.out.println(toLowerCase2("abcH"));
  }
}
