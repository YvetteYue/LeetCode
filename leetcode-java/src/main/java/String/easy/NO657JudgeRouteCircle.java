/**
 * 
 */
package String.easy;

/**
 * @author Administrator
 *
 */
public class NO657JudgeRouteCircle {

  /**
   * 
   *2018年7月18日 下午5:59:34
   * beats:76%
   * 复杂度：
   */
  public static boolean judgeCircle(String moves) {
    int leftAndRight = 0;
    int upAndDown = 0;
    for (char ch : moves.toCharArray()) {
      switch (ch) {
        case 'U':
          upAndDown++;
          break;
        case 'D':
          upAndDown--;
          break;
        case 'L':
          leftAndRight++;
          break;
        case 'R':
          leftAndRight--;
          break;
        default:
          break;
      }
    }
    if(leftAndRight==0&&upAndDown==0){
      return true;
    }
    return false;

  }

  public static void main(String[] args) {
    System.out.println(judgeCircle("UD"));
  }
}
