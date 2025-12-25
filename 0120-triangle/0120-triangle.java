class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return help(0,0,triangle,dp);
    }
    public static int help(int i,int j,List<List<Integer>> al,int[][] dp){
        if(i == al.size()-1){
            return al.get(i).get(j);
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        int down = help(i+1,j,al,dp);
        int right = help(i+1,j+1,al,dp);

        return dp[i][j] = al.get(i).get(j) + Math.min(down,right);
        
    }
}