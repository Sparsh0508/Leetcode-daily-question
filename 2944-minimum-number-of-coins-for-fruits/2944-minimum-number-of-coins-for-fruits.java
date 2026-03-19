class Solution {
    Integer[] dp;
    public int minimumCoins(int[] prices) {
        dp = new Integer[prices.length];
        return help(prices,0);
    }
    public int help(int[] arr,int idx){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int ans = Integer.MAX_VALUE;
        int next = idx+idx+2;
        for(int j = idx+1;j<=next;j++){
            ans = Math.min(ans,help(arr,j));
        }
        return dp[idx] = ans + arr[idx];
    }
}