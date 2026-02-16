class Solution {
    Long[][] dp;
     public long maxAlternatingSum(int[] nums) {
        dp = new Long[nums.length+1][2];
        return help(nums,0,1);
    }
    public static long help(int[] nums,int idx,int even){
        if(idx == nums.length){
            return 0;
        }
        if(dp[])
        long take = 0;
        long skip = 0;
        if(even == 1){
            take = nums[idx]+help(nums,idx+1,0);
            skip = help(nums,idx+1,1);
        }else{
            take = help(nums,idx+1,1) - nums[idx];
            skip = help(nums,idx+1,0);
        }
        return Math.max(take,skip);
    }
}