class Solution {

    private int[][] grid;
    private Integer[][][] memo;
    private int n;
    private static final int NEG_INF = -1_000_000_000;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new Integer[n][n][n];

        int ans = dfs(0, 0, 0);
        return Math.max(0, ans);
    }

    private int dfs(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return NEG_INF;
        }
        
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        
        if (memo[r1][c1][r2] != null) {
            return memo[r1][c1][r2];
        }

        int bestNext = Math.max(
            Math.max(dfs(r1 + 1, c1, r2 + 1), dfs(r1, c1 + 1, r2)),
            Math.max(dfs(r1 + 1, c1, r2), dfs(r1, c1 + 1, r2 + 1))
        );

        if (bestNext == NEG_INF) {
            memo[r1][c1][r2] = NEG_INF;
            return NEG_INF;
        }

        int cherries;
        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        memo[r1][c1][r2] = cherries + bestNext;
        return memo[r1][c1][r2];
    }
}
