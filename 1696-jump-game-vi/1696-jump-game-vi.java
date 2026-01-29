class Solution {
    Integer[] dp;

    public int maxResult(int[] nums, int k) {
        dp = new Integer[nums.length];
        return help(0, nums, k);
    }

    private int help(int idx, int[] nums, int k) {
        // Base case: last index
        if (idx == nums.length - 1) {
            return nums[idx];
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        int max = Integer.MIN_VALUE;

        // Try all jumps from idx+1 to idx+k
        for (int j = idx + 1; j <= idx + k && j < nums.length; j++) {
            int val = help(j, nums, k);
            if (val != Integer.MIN_VALUE) {
                max = Math.max(max, val);
            }
        }

        dp[idx] = nums[idx] + max;
        return dp[idx];
    }
}
