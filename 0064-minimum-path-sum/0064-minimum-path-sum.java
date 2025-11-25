class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        return help(grid,0,0,dp,n,m);
    }
    public static int help(int[][] grid,int r,int c,int[][] dp,int n, int m){
        if(r == n || c == m){
            return Integer.MAX_VALUE;
        }
        if(r == n-1 && c == m-1){
            return grid[r][c];
        }
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        int right = help(grid,r+1,c,dp,n,m);
        int down = help(grid,r,c+1,dp,n,m);
        return dp[r][c] = grid[r][c] + Math.min(right,down);
    }
}