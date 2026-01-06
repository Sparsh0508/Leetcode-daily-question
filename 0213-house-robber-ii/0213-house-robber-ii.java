class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int case1 = help(nums,dp,0,n-2);
        Arrays.fill(dp,-1);
        int case2 = help(nums,dp,1,n-1);
        return Math.max(case1,case2);
    }
    public static int help(int[] nums,int[] dp,int idx,int end){
        if(idx > end){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int steal = nums[idx] + help(nums,dp,idx+2,end);
        int skip = help(nums,dp,idx+1,end);

        return dp[idx] = Math.max(steal,skip);
    }
}