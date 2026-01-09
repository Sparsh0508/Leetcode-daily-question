class Solution {
    public int getMoneyAmount(int n) {
        Integer[][] dp = new Integer[n+1][n+1];
        return help(n,1,dp);
    }
    public static int help(int end,int start,Integer[][] dp){
        if(start >= end){
            return 0;
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }
        int maxi = Integer.MAX_VALUE;
        for(int i = start;i<end;i++){
            maxi = Math.min(maxi,i+Math.max(help(i-1,start,dp),help(end,i+1,dp)));
        }
        return dp[start][end] = maxi;
    }
}