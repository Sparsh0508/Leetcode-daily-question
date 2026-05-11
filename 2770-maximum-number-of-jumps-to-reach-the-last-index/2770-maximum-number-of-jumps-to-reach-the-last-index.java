class Solution {
    static int[] dp;
    public int maximumJumps(int[] nums, int target) {
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int ans = help(nums, target, 0);
        return ans < 0 ? -1 : ans;
    }
    public static int help(int[] nums, int target, int idx) {
        if (idx == nums.length - 1) {
            return 0;
        }
        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }
        int ans = -1;
        for (int i = idx + 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[idx]) <= target) {
                int next = help(nums, target, i);
                if (next != -1) {
                    ans = Math.max(ans, 1 + next);
                }
            }
        }
        return dp[idx] = ans;
    }
}