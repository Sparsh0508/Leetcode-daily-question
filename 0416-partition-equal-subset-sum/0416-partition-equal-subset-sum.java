class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum % 2!= 0){
            return false;
        }
        int target = sum/2;
        Boolean[][] dp = new Boolean[target+1][n+1];
        return help(nums,target,0,dp);
    }
    public static boolean help(int[] nums,int sum,int idx,Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(idx >= nums.length || sum < 0){
            return false;
        }
        if(dp[sum][idx] != null){
            return dp[sum][idx];
        }
        boolean include = help(nums,sum-nums[idx],idx+1,dp);
        boolean exclude = help(nums,sum,idx+1,dp);
        return dp[sum][idx] = include | exclude;
        
    }
}