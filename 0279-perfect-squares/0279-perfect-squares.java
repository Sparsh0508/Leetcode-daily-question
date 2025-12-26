class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return help(n,dp);
    }
    public int help(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = n;
        for(int i = 1;i*i<=n;i++){
            ans = Math.min(ans,1+help(n-(i*i),dp));
        }
        return dp[n] = ans;
    }
}