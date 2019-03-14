package TOPInterviewQuestions.easy;

public class NO122BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        int nums[]={7,1,5,3,6,4};
        System.out.println(new NO122BestTimetoBuyandSellStockII().maxProfit(nums));
    }


    /*
    *   贪心策略 TODO 好好学学
     * @Date 下午5:07 2019/3/10
     * 复杂度：
     * beats：
     **/
    public int maxProfit(int[] prices) {
        int preInMax=Integer.MIN_VALUE;
        int preOutMax=0;
        for(int i=0;i<prices.length;i++){
            if(preInMax<-prices[i]){
                preInMax=-prices[i];
            }
            if(preOutMax-prices[i]>preInMax){
                preInMax=preOutMax-prices[i];
            }
            if(preInMax+prices[i]>preOutMax){
                preOutMax=preInMax+prices[i];
            }
        }
        return preOutMax;
    }
}
