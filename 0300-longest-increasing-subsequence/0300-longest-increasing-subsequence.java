class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(nums,0,-1,dp);
    }
    public static int help(int[] nums,int curr,int prev,int[][] dp){
        if(curr == nums.length){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev];
        }
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + help(nums,curr+1,curr,dp);
        }

        int notTake = 0 + help(nums,curr+1,prev,dp);
        return dp[curr][prev+1] = Math.max(take,notTake);
    }
}