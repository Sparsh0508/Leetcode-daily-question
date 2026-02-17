class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length+1];
        return Math.min(minCost(cost,0) , minCost(cost,1)); 

    }
    public int minCost(int[] cost,int idx) {
        if(idx >= cost.length){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        
        return dp[idx]= (cost[idx] + Math.min(minCost(cost,idx+1),minCost(cost,idx+2)));
    }
}