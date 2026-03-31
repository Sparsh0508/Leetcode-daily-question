class Solution {
    Integer[][] dp;

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        dp = new Integer[m][n];
        if (grid[0][0] == 1) return 0;
        
        return helper(grid, 0, 0);
    }

    public int helper(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= m || j >= n) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != null) return dp[i][j];

        int down = helper(grid, i + 1, j);
        int right = helper(grid, i, j + 1);

        return dp[i][j] = down + right;
    }
}