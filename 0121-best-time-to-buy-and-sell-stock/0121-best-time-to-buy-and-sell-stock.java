class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return help(prices,0,1);
    }
    public int help(int[] prices,int idx,int buy){
        if(prices.length == idx ){
            return 0;
        }
        if(dp[idx][buy] != null){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + help(prices,idx+1,0);
            int skip = help(prices,idx+1,1);
            profit = Math.max(take,skip);
        }else{
            int sell = prices[idx];
            int skip = help(prices,idx+1,0);
            profit = Math.max(sell,skip);
        }
        return dp[idx][buy] = profit;
    }
}