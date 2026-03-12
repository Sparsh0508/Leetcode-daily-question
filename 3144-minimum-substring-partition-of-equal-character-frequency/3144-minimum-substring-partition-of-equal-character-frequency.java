class Solution {
    Integer[] dp;
    public int minimumSubstringsInPartition(String s) {
        dp = new Integer[s.length()];
        return help(s,0);
    }
    public int help(String s,int idx){
        if(idx == s.length()){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int[] count = new int[26];
        int res = Integer.MAX_VALUE;
        for(int i = idx;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            if(isBalanced(count)){
                res = Math.min(res,1 + help(s,i+1));
            }
        }
        return dp[idx] = res;
    }
    public boolean isBalanced(int[] count){
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int c : count) {
            if (c > 0) {
                min = Math.min(min, c);
                max = Math.max(max, c);
            }
        }

        return min == max;
    }

}