class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(0,0,s1,s2,s3,dp);
    }
    public static boolean help(int i,int j ,String s1,String s2,String s3,int[][] dp){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        boolean found = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            found = found || help(i+1,j,s1,s2,s3,dp);
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            found = found || help(i,j+1,s1,s2,s3,dp);
        }
        dp[i][j] = found ? 1 : 0;
        return found;
    }
}