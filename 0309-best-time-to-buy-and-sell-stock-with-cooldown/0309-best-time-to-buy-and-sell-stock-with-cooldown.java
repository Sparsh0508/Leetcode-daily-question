class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][2];
        return help(prices,0,1);
    }
    public int help(int[] arr,int idx,int canBuy){
        if(arr.length <= idx){
            return 0;
        }
        if(dp[idx][canBuy] != null){
            return dp[idx][canBuy];
        }
        int profit = 0;
        if(canBuy == 1){
            int buy = -arr[idx] + help(arr,idx+1,0);
            int skip = help(arr,idx+1,1);
            profit = Math.max(buy,skip);
        }else{
            int sell = arr[idx] + help(arr,idx+2,1);
            int skip = help(arr,idx+1,0);
            profit = Math.max(sell,skip);
        }
        return dp[idx][canBuy] = profit;

    }
}