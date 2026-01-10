class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length+1][2][3];
        return help(prices,0,1,2,dp);
    }
    public static int help(int[] prices,int idx,int buy,int k,Integer[][][] dp){
        if(idx == prices.length || k == 0){
            return 0;
        }
        if(dp[idx][buy][k] != null){
            return dp[idx][buy][k];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + help(prices,idx+1,0,k,dp);
            int skip = help(prices,idx+1,1,k,dp);
            profit = Math.max(take,skip);
        }else{
            int sell = prices[idx] + help(prices,idx+1,1,k-1,dp);
            int skip = help(prices,idx+1,0,k,dp);
            profit = Math.max(sell,skip);
        }
        return dp[idx][buy][k] = profit;
    }
}