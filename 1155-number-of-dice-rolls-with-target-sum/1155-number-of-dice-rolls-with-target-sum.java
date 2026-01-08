class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(n,k,target,dp);
    }
    public static int help(int dice,int face,int target,int[][] dp){
        if(target < 0){
            return 0;
        }
        if(dice == 0 && target != 0){
            return 0;
        }
        if(dice != 0 && target == 0){
            return 0;
        }
        if(dice == 0 && target == 0){
            return 1;
        }
        if(dp[dice][target] != -1){
            return dp[dice][target];
        }
        long ans = 0;
        for(int i = 1;i<=face;i++){
            ans += help(dice-1,face,target-i,dp);
        }
        ans = ans % 1_000_000_007;
        return dp[dice][target] = (int)ans;
    }
}