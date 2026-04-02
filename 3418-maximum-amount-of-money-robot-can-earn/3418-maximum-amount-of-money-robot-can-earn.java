class Solution {
    static Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        dp = new Integer[coins.length][coins[0].length][3];
        return help(coins,0,0,2);
    }
    public static int help(int[][] coins,int i,int j,int k){
        if(i >= coins.length || j >= coins[0].length){
            return Integer.MIN_VALUE;
        }
        if(i == coins.length-1 && j == coins[0].length -1){
            if (coins[i][j] < 0 && k > 0) return 0;
            return coins[i][j];
        }
        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }
        int val = coins[i][j];
        int next = Math.max(help(coins,i+1,j,k) , help(coins,i,j+1,k));
        int take = val + next;

        int skip = Integer.MIN_VALUE;
        if(val < 0 && k > 0){
            int nextStep = Math.max(help(coins,i+1,j,k-1), help(coins,i,j+1,k-1));
            skip = nextStep;
        }
        return dp[i][j][k] = Math.max(take,skip);


    }
}