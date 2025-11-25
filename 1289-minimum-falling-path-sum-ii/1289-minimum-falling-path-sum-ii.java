class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dp[i][j] = -101;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            ans = Math.min(ans,help(matrix,0,i,dp,n,m));
        }
        return ans;
    }
    public static int help(int[][] mat,int r,int c,int[][] dp,int n,int m){
        if(r < 0 || r == n || c < 0 || c == m){
            return Integer.MAX_VALUE;
        }
        if(r == n-1){
            return mat[r][c];
        }
        if(dp[r][c] != -101){
            return dp[r][c];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<mat[0].length;i++){
            if(i == c){
                continue;
            }
            int ans = help(mat,r+1,i,dp,n,m);
            if(ans != Integer.MAX_VALUE){
                min = Math.min(ans,min);
            }
        }
        if(min == Integer.MAX_VALUE){
            dp[r][c] = Integer.MAX_VALUE;
        }else{
            dp[r][c] = mat[r][c] + min;
        }
        return dp[r][c];
    }
}