class Solution {
    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        int[][] dp = new int[sat.length+1][sat.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(sat ,0,1,dp);
    }
    public static int help(int[] sat,int idx,int time,int[][] dp){
        if(idx == sat.length){
            return 0;
        }
        if(dp[idx][time] != -1){
            return dp[idx][time];
        }
        int isInclude = (sat[idx]* time) + help(sat,idx+1,time+1,dp);
        int isExclude = help(sat,idx+1,time,dp);

        return dp[idx][time] = Math.max(isInclude,isExclude);

    }
}