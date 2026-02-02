class Solution {
    int mod = 1_000_000_007;
    Long[] dp;
    public int countHousePlacements(int n) {
        dp = new Long[n+1];
        long ansOne = help(n);
        return (int)((ansOne*ansOne) % mod);
    }
    public long help(int n){
        if(n== 0){
            return 1;
        }
        if(n == 1){
            return 2;
        }
        if(dp[n] != null){
            return dp[n];
        }
        long ans = (help(n-1) + help(n-2)) % mod;
        return dp[n] = ans;
    }
}