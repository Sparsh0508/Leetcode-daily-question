class Solution {
     static int[][] dp;
    public int longestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return help(X, Y, m - 1, n - 1);
    }

    private int help(String X, String Y, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (X.charAt(i) == Y.charAt(j)) {
            dp[i][j] = 1 + help(X, Y, i - 1, j - 1);
        } 
        else {
            dp[i][j] = Math.max(
                help(X, Y, i - 1, j),
                help(X, Y, i, j - 1)
            );
        }

        return dp[i][j];
    }
}
