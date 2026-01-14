class Solution {
    Integer[][] dp;
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;

        //first tow
        dp = new Integer[n][n];
        int score = nums[0] + nums[1];
        ans = Math.max(ans,1 + help(nums,score,2,n-1));

        // last two
        dp = new Integer[n][n];
        score = nums[n-2] + nums[n-1];
        ans = Math.max(ans,1 + help(nums,score,0,n-3));

        // first and last 
        dp = new Integer[n][n];
        score = nums[0] + nums[n-1];
        ans = Math.max(ans,1 + help(nums,score,1,n-2));
        
        return ans;
    }
    public int help(int[] nums,int score,int l,int r){
        if(l >= r){
            return 0;
        }
        if(dp[l][r] != null){
            return dp[l][r];
        }
        int ans = 0;
        // first Two
        if(l +1 <= r && nums[l] + nums[l+1] == score){
            ans = Math.max(ans,1 + help(nums,score,l+2,r));
        }
        //Last Two
        if(l <= r-1 && nums[r-1] + nums[r] == score){
            ans = Math.max(ans,1 + help(nums,score,l,r-2));
        }
        //first and last two
        if(nums[l] + nums[r] == score){
            ans = Math.max(ans,1 + help(nums,score,l+1,r-1));
        }
        return dp[l][r] = ans;
    }
}