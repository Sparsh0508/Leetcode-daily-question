class Solution {
    Integer[][] dp;
    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return help(s,0,s.length()-1);
    }
    public int help(String s,int i ,int j){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = help(s,i+1,j-1);
        }
        int skip1 = 1+ help(s,i+1,j);
        int skip2 = 1+ help(s,i,j-1);
        return dp[i][j] = Math.min(skip1,skip2);
    }
}