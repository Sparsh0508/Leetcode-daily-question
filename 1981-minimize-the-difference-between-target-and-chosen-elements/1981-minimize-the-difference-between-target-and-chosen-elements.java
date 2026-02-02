class Solution {
    Integer[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        int maxSum = mat.length * 70;
        dp = new Integer[mat.length][maxSum + 1];
        return dfs(mat, 0, 0, target);
    }

    public int dfs(int[][] mat, int row, int sum, int target) {
        if (row == mat.length) {
            return Math.abs(sum - target);
        }

        if (dp[row][sum] != null) {
            return dp[row][sum];
        }

        int res = Integer.MAX_VALUE;

        for (int val : mat[row]) {
            res = Math.min(res, dfs(mat, row + 1, sum + val, target));
            if (res == 0) break; 
        }

        return dp[row][sum] = res;
    }
}
