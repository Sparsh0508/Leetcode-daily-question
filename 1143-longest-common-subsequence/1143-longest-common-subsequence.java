class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()+1][text2.length()+1];
        return help(text1,text2,0,0);
    }
    public int help(String s,String t,int idx1,int idx2){
        if(idx1 == s.length() || idx2 == t.length()){
            return 0;
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1) == t.charAt(idx2)){
            return dp[idx1][idx2] = 1 + help(s,t,idx1+1,idx2+1);
        }
        int take1 = help(s,t,idx1+1,idx2);
        int take2 = help(s,t,idx1,idx2+1);
        return dp[idx1][idx2] = Math.max(take1,take2);
    }
}