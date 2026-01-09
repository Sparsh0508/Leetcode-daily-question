class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n+1][2];
        return help(prices,dp,0,1);
    }
    public static int help(int[] arr,Integer[][] dp,int idx,int canBuy){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][canBuy] != null){
            return dp[idx][canBuy];
        }
        int profit = 0;
        if(canBuy == 1){
            int buy = -arr[idx] + help(arr,dp,idx+1,0);
            int skip = help(arr,dp,idx+1,1);
            profit = Math.max(buy,skip);
        }
        else{
            int sell = arr[idx];
            int skip = help(arr,dp,idx+1,0);
            profit = Math.max(sell,skip);
        }
        return dp[idx][canBuy] = profit;

    }
}