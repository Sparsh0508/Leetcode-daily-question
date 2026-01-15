class Solution {
    Boolean [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return help(s,p,s.length()-1,p.length()-1);
    }
    public boolean help(String s,String p,int idx1,int idx2){
        if(idx2 < 0  && idx1 < 0){
            return true;
        }
        if(idx1 >= 0 && idx2 < 0){
            return false;
        }
        if(idx1 < 0 && idx2 >= 0){
            for(int k = 0;k<=idx2;k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?'){
            return dp[idx1][idx2] = help(s,p,idx1-1,idx2-1);
        }else if(p.charAt(idx2) == '*'){
            return dp[idx1][idx2] = help(s,p,idx1-1,idx2) || help(s,p,idx1,idx2-1);
        }else{
            return dp[idx1][idx2] = false;
        }

    }
}