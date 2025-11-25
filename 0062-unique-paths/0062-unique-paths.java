class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            for(int j = 0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return help(m,n,dp);
    }
    public static int help(int m,int n,int[][] dp){
        if(m == 1 || n == 1){
            return 1;
        }
        if(m==0 || n == 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int right = help(m,n-1,dp);
        int left = help(m-1,n,dp);
        return dp[m][n] = right+left;
    }
}