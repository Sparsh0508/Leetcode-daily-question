class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[obstacles.length+1];
        Arrays.fill(dp,-1);
        return help(obstacles,0,2,dp);
    }
    public int help(int[] nums,int idx,int lane,int[] dp){
        if(idx == nums.length-1){
            return 0;
        }
        if(nums[idx+1] != lane){
            return help(nums,idx+1,lane,dp);
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        else{
            int ans = Integer.MAX_VALUE;
            for(int i = 1;i<=3;i++){
                if(lane != i && nums[idx] != i){
                    ans = Math.min(ans,1+help(nums,idx,i,dp));
                }
            }
            return dp[idx] = ans;
        }
    }
}