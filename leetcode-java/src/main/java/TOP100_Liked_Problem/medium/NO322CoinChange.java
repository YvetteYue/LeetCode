package TOP100_Liked_Problem.medium;

import java.util.Arrays;

public class NO322CoinChange {

    /*
    *
     * @Date 下午1:40 2019/4/21
     * 复杂度：o(n^2)
     * beats：88%
     **/
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[i]=min(dp[i-coins[i]]+1)
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length&&coins[j]<=i;j++){
                if(dp[i-coins[j]]==-1) continue;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
            if(dp[i]==Integer.MAX_VALUE) dp[i]=-1;
        }
        return dp[amount];
    }


    /*
    *   两个循环反过来了
     * @Date 下午1:48 2019/4/21
     * 复杂度：
     * beats：95%
     **/
    public int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] > amount) return -1;
        return dp[amount];
    }



    //1 ms
    int minCount = Integer.MAX_VALUE;//通过这个全局变量进行回溯法的剪枝
    /*
    *   TODO dfs
     * @Date 下午2:02 2019/4/21
     * 复杂度：o(2^n)
     * beats：100%
     **/
    public int coinChange4(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(amount, coins.length-1, coins, 0);
        return minCount == Integer.MAX_VALUE?-1:minCount;
    }
    private void dfs(int amount, int start, int[] coins, int count){
        if (start<0 || count+2>minCount) return;

        for (int i = amount/coins[start];i>=0;i--){
            //贪心：从最大面值的开始进行dfs,且一次尽可能的先多用最大面值。不行则回退，少用一张大面值
            int newAmount = amount - i*coins[start];
            int newCount = count + i;
            if (newAmount>0 && newCount+1<minCount)//??剪枝，只递归可能的地方
                dfs(newAmount, start-1, coins, newCount);
            else{
                if(newAmount==0 && newCount<minCount)//发现了新的最短路径
                    minCount = newCount;
                break;
            }
        }
    }
}
