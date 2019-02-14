package TOP100_Liked_Problem.medium;

public class NO279PerfectSquares {

//    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//    Example 1:
//    Input: n = 12
//    Output: 3
//    Explanation: 12 = 4 + 4 + 4.
//    Example 2:
//    Input: n = 13
//    Output: 2
//    Explanation: 13 = 4 + 9.

    public static void main(String[] args) {
        System.out.println(new NO279PerfectSquares().numSquares2(12));
    }

    /*
     *   dfs 暴力解决
     * @Date 下午12:13 2019/2/14
     * 复杂度：
     * beats：1.01%
     **/
    public int numSquares(int n) {
        dfs(n, n, 0);
        return result;
    }

    int result = Integer.MAX_VALUE;

    private void dfs(int n, int nowSum, int times) {
        if (times > result) return;
        if (nowSum == 0) {
            if (times < result) {
                result = times;
            }
            return;
        } else {
            int tmp = (int) Math.sqrt(nowSum);
            for (int i = tmp; i > 0; i--) {
                dfs(n, nowSum - i * i, times + 1);
            }
        }
    }

    /*
    *
     * @Date 下午1:08 2019/2/14
     * 复杂度：
     * beats：91.93%
     **/
    public int numSquares2(int n) {
        int nums[] = new int[n+1];
        if (n == 1) return 1;
        for (int i = 0; i <= n; i++) {
            int tmp = (int) Math.sqrt(i);
            if (i == 0) nums[i] = 0;
            else if (i == 1) nums[i] = 1;
            else if (tmp * tmp == i) nums[i] = 1;
            else {
                int nowMin=Integer.MAX_VALUE;
                //优化在 只要循环 1~sqrt(i) 即可
                for (int k = 1; k <=tmp; k++) {
                    if(nowMin>nums[k*k]+nums[i-k*k]){
                        nowMin=nums[k*k]+nums[i-k*k];
                    }
                }
                nums[i]=nowMin;
            }
        }
        return nums[n];
    }


    //TODO https://www.jianshu.com/p/2925f4d7511b  四平方定理
}
