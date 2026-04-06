class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        dp = new Integer[m][m];
        return solve(nums, multipliers, 0, 0);
    }

    public int solve(int[] nums, int[] mul, int left, int k) {
        if (k == mul.length) return 0;

        if (dp[left][k] != null) return dp[left][k];

        int n = nums.length;
        int right = n - 1 - (k - left);

        int pickLeft = mul[k] * nums[left] + solve(nums, mul, left + 1, k + 1);
        int pickRight = mul[k] * nums[right] + solve(nums, mul, left, k + 1);

        return dp[left][k] = Math.max(pickLeft, pickRight);
    }
}