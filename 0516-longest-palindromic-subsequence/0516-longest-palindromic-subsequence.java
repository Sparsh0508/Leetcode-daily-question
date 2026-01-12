class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        dp = new Integer[s.length()+1][t.length()+1];
        return help(s,t,0,0);
    }
    public int help(String s1,String s2,int idx1,int idx2){
        if(idx1 == s1.length() || idx2 == s2.length()){
            return 0;
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + help(s1,s2,idx1+1,idx2+1);
        }
        int take1 = help(s1,s2,idx1+1,idx2);
        int take2 = help(s1,s2,idx1,idx2+1);
        return dp[idx1][idx2] = Math.max(take1,take2);
    }
}