class Solution {
    long[][][] dp = new long[16][16][2];
    boolean[][] vis = new boolean[16][16];
    long MOD = 1000000007;

    long[] solve(int i,int j,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
      
        if(i==n-1 && j==m-1){
            return new long[]{grid[i][j],grid[i][j]};
        }
      
        if(vis[i][j]) return dp[i][j];
        vis[i][j] = true;

        long maxi_p = Long.MIN_VALUE;
        long mini_p = Long.MAX_VALUE;

        if(j+1<m){
            long[] res = solve(i,j+1,grid);
            long first = grid[i][j] * res[0];
            long second = grid[i][j] * res[1];
            maxi_p = Math.max(maxi_p,Math.max(first,second));
            mini_p = Math.min(mini_p,Math.min(first,second));
        }
        if(i+1<n){
            long[] res = solve(i+1,j,grid);
            long first = grid[i][j] * res[0];
            long second = grid[i][j] * res[1];
            maxi_p = Math.max(maxi_p,Math.max(first,second));
            mini_p = Math.min(mini_p,Math.min(first,second));
        }
        dp[i][j] = new long[]{mini_p,maxi_p};
        return dp[i][j];
    }

    public int maxProductPath(int[][] grid) {
        for(int i=0;i<16;i++) for(int j=0;j<16;j++) vis[i][j]=false;

        long[] res = solve(0,0,grid);
        if(res[1] < 0) return -1;
        return (int)(res[1] % MOD);
    }
}