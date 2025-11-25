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
        if(r == n || c < 0 || c == m){
            return Integer.MAX_VALUE;
        }
        if(r == n-1){
            return mat[r][c];
        }
        if(dp[r][c] != -101){
            return dp[r][c];
        }
        int down = help(mat,r+1,c,dp,n,m);
        int left = help(mat,r+1,c-1,dp,n,m);
        int right = help(mat,r+1,c+1,dp,n,m);
        return dp[r][c] = mat[r][c] + Math.min(down,Math.min(left,right));
    }
}