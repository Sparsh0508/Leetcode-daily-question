class Solution {
    int[][] dp;

    public int maxSizeSlices(int[] nums) {
        int k = nums.length;
        int n = k / 3;

        dp = new int[k][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int case1 = help(nums, 0, k - 2, n);

        dp = new int[k][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int case2 = help(nums, 1, k - 1, n);

        return Math.max(case1, case2);
    }

    int help(int[] arr, int idx, int end, int n) {
        if (n == 0 || idx > end) return 0;
        if (dp[idx][n] != -1) return dp[idx][n];

        int take = arr[idx] + help(arr, idx + 2, end, n - 1);
        int skip = help(arr, idx + 1, end, n);

        return dp[idx][n] = Math.max(take, skip);
    }
}