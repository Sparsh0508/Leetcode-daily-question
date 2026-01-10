class Solution {
    public int maxProfit(int[] prices, int fees) {
        Integer[][] dp = new Integer[prices.length+1][2]; 
        return help(prices,fees,0,1,dp);
    }
    public static int help(int[] prices,int fees,int idx,int buy,Integer[][] dp){
        if(prices.length == idx){
            return 0;
        }
        if(dp[idx][buy] != null){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + help(prices,fees,idx+1,0,dp);
            int skip = help(prices,fees,idx+1,1,dp);
            profit = Math.max(take,skip);
        }
        else{
            int sell = prices[idx] + help(prices,fees,idx+1,1,dp) - fees;
            int skip = help(prices,fees,idx+1,0,dp); 
            profit = Math.max(sell,skip);
        }
        return dp[idx][buy] = profit;
    }
}