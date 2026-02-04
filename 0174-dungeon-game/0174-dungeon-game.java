class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        Integer[][] dp = new Integer[n][m];
        
        return help(dungeon,0,0,dp,n,m);
    }
    public static int help(int[][] mat,int r,int c,Integer[][] dp,int n, int m){
        if(r == n || c==m){
            return Integer.MAX_VALUE;
        }
        if(r == n-1 && c == m-1){
            return mat[r][c] >0 ? 1 : 1-mat[r][c];
        }
        if(dp[r][c] != null ){
            return dp[r][c];
        }
        int right = help(mat,r,c+1,dp,n,m);
        int down = help(mat,r+1,c,dp,n,m);

        int minNextHealth = Math.min(right,down);

        int healthNeeded = minNextHealth - mat[r][c];
        return dp[r][c] = Math.max(1,healthNeeded);

    }
}