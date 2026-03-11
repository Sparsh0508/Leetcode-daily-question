class Solution {
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int i, int j) {
        if(j == p.length()){
            return i == s.length();
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean ans = false;
        boolean firstMatch = false;
        if(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
            firstMatch = true;
        }
        if(j + 1<p.length() && p.charAt(j+1) == '*'){
            ans = (help(s,p,i,j+2) || (firstMatch && help(s,p,i+1,j)));
        }else{
            ans = firstMatch && help(s,p,i+1,j+1);
        }
        return dp[i][j] = ans;
    }
}
