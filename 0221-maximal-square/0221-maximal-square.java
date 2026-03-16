class Solution {
    int max = 0;
    Integer[][] dp;
    public int maximalSquare(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        dp = new Integer[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                help(mat,i,j);
            }
        }
        return max * max;
    }

    public int help(char[][] mat,int i,int j){
        if(i >= mat.length || j >= mat[0].length){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int right = help(mat,i,j+1);
        int down = help(mat,i+1,j);
        int diag = help(mat,i+1,j+1);

        if(mat[i][j] == '1'){
            int ans = 1 + Math.min(right,Math.min(down,diag));
            max = Math.max(max,ans);
            return dp[i][j] =ans;
        }
        return dp[i][j] = 0;
    }
}