class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()+1][word2.length()+1];
        return help(word1,word2,0,0);
    }
    public int help(String word1,String word2,int idx1,int idx2){
        if(idx1 == word1.length()){
            return word2.length() - idx2 ;
        }else if(idx2 == word2.length()){
            return word1.length() - idx1;
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        int ans = 0;
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            return dp[idx1][idx2] = help(word1,word2,idx1+1,idx2+1);
        }else{
            int insertAns = 1 + help(word1,word2,idx1,idx2+1);
            int deleteAns = 1 + help(word1,word2,idx1+1,idx2);
            int replaceAns = 1 + help(word1,word2,idx1+1,idx2+1);
            ans = Math.min(insertAns,Math.min(deleteAns,replaceAns));
        }
        return dp[idx1][idx2] = ans;
    }
}