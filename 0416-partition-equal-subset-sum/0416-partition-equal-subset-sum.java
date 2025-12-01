class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return help(nums,dp,target,0);
    }
    public static boolean help(int[] nums,Boolean[][] dp,int target,int idx){
        if(target == 0){
            return true;
        }
        if(idx >= nums.length || target < 0){
            return false;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        boolean include = help(nums,dp,target-nums[idx],idx+1);
        boolean exclude = help(nums,dp,target,idx+1);
        return dp[idx][target] = include | exclude;
    }
}