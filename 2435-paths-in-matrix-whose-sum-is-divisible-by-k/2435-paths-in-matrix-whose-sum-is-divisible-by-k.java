class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][k];
        return help(grid, dp, n, m, k, 0, 0, 0);
    }

    public int help(int[][] grid, Integer[][][] dp, int n, int m, int k,
                    int r, int c, int mod) {

        mod = (mod + grid[r][c]) % k;

        if (r == n - 1 && c == m - 1) {
            return (mod == 0) ? 1 : 0;
        }

        if (dp[r][c][mod] != null) {
            return dp[r][c][mod];
        }

        long ways = 0;


        if (c + 1 < m) {
            ways = (ways + help(grid, dp, n, m, k, r, c + 1, mod)) % MOD;
        }

        if (r + 1 < n) {
            ways = (ways + help(grid, dp, n, m, k, r + 1, c, mod)) % MOD;
        }

        dp[r][c][mod] = (int) ways;
        return dp[r][c][mod];
    }
}
