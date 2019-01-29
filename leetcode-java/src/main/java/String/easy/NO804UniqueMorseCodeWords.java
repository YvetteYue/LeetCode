/**
 * 
 */
package String.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class NO804UniqueMorseCodeWords {

  /**
   * 
   *2018年7月18日 下午5:48:17
   * beats:71%
   * 复杂度：
   */
  public static int uniqueMorseRepresentations(String[] words) {
    String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
        "-..-", "-.--", "--.."};
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < words.length; i++) {
      String string = "";
      char[] chars = words[i].toCharArray();
      for (int j = 0; j < words[i].length(); j++) {
        string += morseCode[chars[j] - 'a'];
      }
      set.add(string);
    }
    return set.size();
  }

  /**
   * StringBuilder比string在字符串拼接上更优
   *2018年7月18日 下午5:50:02
   * beats:91.88%
   * 复杂度：
   */
  public static int uniqueMorseRepresentations2(String[] words) {
    String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
        "-..-", "-.--", "--.."};
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < words.length; i++) {
      StringBuilder string=new StringBuilder();
      char[] chars = words[i].toCharArray();
      for (int j = 0; j < words[i].length(); j++) {
        string.append(morseCode[chars[j] - 'a']);
      }
      set.add(string.toString());
    }
    return set.size();
  }
  public static void main(String[] args) {
    String[] words={"gin", "zen", "gig", "msg"};
    System.out.println(uniqueMorseRepresentations2(words));
  }
}
