class Solution {
    public int numTrees(int n) {
        Integer[] dp = new Integer[n+1];
        return help(n,dp);
    }
    public int help(int n,Integer[] dp){
        if(n<=1){
            return 1;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int ans = 0;
        for(int i =1;i<=n;i++){
            ans += help(i-1,dp) * help(n-i,dp);
        }
        return dp[n] = ans;
    }
}