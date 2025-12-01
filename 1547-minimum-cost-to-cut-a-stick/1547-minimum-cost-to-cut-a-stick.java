class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i = 1;i<=m;i++){
            arr[i] = cuts[i-1];
        }
        Arrays.sort(arr);
        Integer[][] dp = new Integer[m+2][m+2];
        return help(arr,dp,0,m+1);
    }
    public static int help(int[] cuts,Integer[][] dp,int i,int j){
        if(i+1 >= j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int cost = cuts[j] - cuts[i] + help(cuts,dp,i,k) + help(cuts,dp,k,j);
            ans = Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
}