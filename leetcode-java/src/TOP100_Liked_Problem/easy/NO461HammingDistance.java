/**
 * 
 */
package TOP100_Liked_Problem.easy;

/**
 * @author Administrator
 *
 */
public class NO461HammingDistance {

  /**
   * 迭代 
   * 2018年7月19日 下午6:30:39 
   * beats:99.2% 
   * 复杂度：
   */
  public static int hammingDistance(int x, int y) {
    int num = x ^ y;
    int sum = 0;
    while (num != 0) {
      int k = num & 1;
      if (k == 1) {
        sum++;
      }
      num = num >> 1;
    }
    return sum;
  }

  /**
   * 递归 f(x,y)=(x^y)%2+f(x/2,y/2); 
   * 2018年7月20日 上午9:51:57 
   * beats:99.2% 
   * 复杂度：
   */
  public int hammingDistance1(int x, int y) {
    if ((x ^ y) == 0)
      return 0;
    return (x ^ y) % 2 + hammingDistance(x / 2, y / 2);
  }

  public static void main(String[] args) {
    System.out.println(hammingDistance(1, 4));
  }
}
