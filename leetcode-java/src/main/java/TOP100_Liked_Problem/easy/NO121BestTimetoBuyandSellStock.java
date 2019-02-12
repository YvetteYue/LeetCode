package TOP100_Liked_Problem.easy;

public class NO121BestTimetoBuyandSellStock {

//    Say you have an array for which the ith element is the price of a given stock on day i.
//    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
//    design an algorithm to find the maximum profit.
//    Note that you cannot sell a stock before you buy one.
//        Example 1:
//    Input: [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Not 7-1 = 6, as selling price needs to be larger than buying price.
//    Example 2:
//    Input: [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.

    public static void main(String[] args) {
        int nums[]={7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    /*
    *   注意只有一次交易！
     * @Date 上午11:48 2019/2/12
     * 复杂度：
     * beats：99.88%
     **/
    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int premin=-prices[0];
        int result=premin;
        for(int i=1;i<prices.length;i++){
            if(premin+prices[i]>result){
                result=premin+prices[i];
            }
            if(premin<-prices[i]){
                premin=-prices[i];
            }
        }
        if(result<0)return 0;
        return result;
    }
}
