class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length+1][2];
        return help(prices,0,1,dp);
    }
    public static int help(int[] price ,int idx,int buy,Integer[][] dp){
        if(idx == price.length){
            return 0;
        }
        if(dp[idx][buy] != null){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -price[idx] + help(price,idx+1,0,dp);
            int skip = help(price,idx+1,1,dp);
            profit = Math.max(take,skip);
        }else{
            int sell = price[idx] + help(price,idx+1,1,dp);
            int skip = help(price,idx+1,0,dp);
            profit = Math.max(sell,skip);
        }
        return profit;
    }
}