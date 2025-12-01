class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] dp = new Integer[m][n];
        int ans = help(word1,word2,dp,m,n,0,0);
        return ans;
    }
    public static int help(String word1,String word2,Integer[][] dp ,int m,int n,int i,int j){
        if(i == m|| j == n){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = 1+help(word1,word2,dp,m,n,i+1,j+1);
        }else{
            int skip1 = help(word1,word2,dp,m,n,i+1,j);
            int skip2 = help(word1,word2,dp,m,n,i,j+1);
            dp[i][j] = Math.max(skip1,skip2);
        }
        return dp[i][j];
    }
}