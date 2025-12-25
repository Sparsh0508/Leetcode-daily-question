class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            ans = Math.max(ans,help(nums,dp,i));
        }
        return ans;
    }
    public static int help(int[] nums,int[] dp,int i){
        if(dp[i] != -1){
            return dp[i];
        }
        int maxLen = 1;
        for(int j = i+1;j<nums.length;j++){
            if(nums[j]>nums[i]){
                maxLen = Math.max(maxLen,1+help(nums,dp,j));
            }
        }
        return dp[i] = maxLen;
    }
}