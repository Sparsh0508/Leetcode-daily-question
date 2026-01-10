class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()];
        return help(s1,s2,0,0,dp);

    }
    public static int help(String s1,String s2,int idx1,int idx2,Integer[][] dp){
        if (idx1 == s1.length()) {
            int sum = 0;
            while (idx2 < s2.length()) {
                sum += s2.charAt(idx2++);
            }
            return sum;
        }
        if (idx2 == s2.length()) {
            int sum = 0;
            while (idx1 < s1.length()) {
                sum += s1.charAt(idx1++);
            }
            return sum;
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return help(s1, s2, idx1 + 1, idx2 + 1,dp);
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        int delete1 = s1.charAt(idx1) + help(s1,s2,idx1+1,idx2,dp);
        int delete2 = s2.charAt(idx2) + help(s1,s2,idx1,idx2+1,dp);
        return dp[idx1][idx2] = Math.min(delete1,delete2);
    }
}