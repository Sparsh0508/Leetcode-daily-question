class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount+1];
        return help(coins,amount,memo,0);
    }
    public static int help(int[] coins,int sum,Integer[][] memo,int i){
        if(sum == 0){
            return 1;
        }
        if(coins.length == i){
            return 0;
        }
        if(memo[i][sum] != null){
            return memo[i][sum];
        }
        int take = 0;
        if(coins[i] <= sum){
            take = help(coins,sum-coins[i],memo,i);
        }
        int skip = help(coins,sum,memo,i+1);
        return memo[i][sum] = take+skip;
    }
}