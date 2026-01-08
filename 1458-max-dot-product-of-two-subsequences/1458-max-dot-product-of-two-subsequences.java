class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(nums1, nums2, 0, 0, dp);
    }

    public int help(int[] nums1, int[] nums2, int i, int j,int[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = nums1[i] * nums2[j] + Math.max(0, help(nums1, nums2, i + 1, j + 1,dp));

        int skip1 = help(nums1, nums2, i + 1, j, dp);
        int skip2 = help(nums1, nums2, i, j + 1, dp);

        return dp[i][j] = Math.max(take, Math.max(skip1, skip2));
    }
}
