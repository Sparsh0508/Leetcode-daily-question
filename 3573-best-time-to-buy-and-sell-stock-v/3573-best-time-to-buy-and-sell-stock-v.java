class Solution {
    Long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length][k+1][3];
        return help(prices,k,0,0);
    }
    public long help(int[] prices,int k,int idx,int st){
        if (idx == prices.length) {
            return st == 0 ? 0 : Long.MIN_VALUE / 2;
        }
        if (k == 0) {
            return st == 0 ? help(prices, k, idx + 1, 0)
                           : Long.MIN_VALUE / 2;
        }
        if(dp[idx][k][st] != null){
            return dp[idx][k][st];
        }
        long profit = Long.MIN_VALUE / 2;
        if(st == 0){
            long buy = -prices[idx] + help(prices,k,idx+1,1);
            long sell = prices[idx] + help(prices,k,idx+1,2);
            long skip = help(prices,k,idx+1,0);
            profit = Math.max(buy,Math.max(sell,skip));
        }else if(st == 1){
            long sell = prices[idx] + help(prices,k-1,idx+1,0);
            long skip = help(prices,k,idx+1,1);
            profit = Math.max(sell,skip); 
        }else{
            long buy = -prices[idx] + help(prices,k-1,idx+1,0);
            long skip = help(prices,k,idx+1,2);
            profit = Math.max(buy,skip);
        }
        return dp[idx][k][st] = profit;

    }
}