class Solution {
    Long[][] dp;
    public long maxEnergyBoost(int[] A, int[] B) {
        int n = A.length;
        dp = new Long[n][3]; 
        return solve(A, B, 0, 2);
    }

    public long solve(int[] A, int[] B, int idx, int last) {
        if (idx >= A.length) return 0;
        if (dp[idx][last] != null) return dp[idx][last];

        long ans = 0;
        if (last == 1) {
            ans = Math.max(ans, solve(A, B, idx + 1, 2));
        } else {
            ans = Math.max(ans, A[idx] + solve(A, B, idx + 1, 0));
        }
        if (last == 0) {
            ans = Math.max(ans, solve(A, B, idx + 1, 2));
        } else {
            ans = Math.max(ans, B[idx] + solve(A, B, idx + 1, 1));
        }
        ans = Math.max(ans, solve(A, B, idx + 1, 2));

        return dp[idx][last] = ans;
    }
}