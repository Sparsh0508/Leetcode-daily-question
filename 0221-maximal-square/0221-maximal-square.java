class Solution {
    public int maximalSquare(char[][] mat) {
        int[] maxa = new int[1];
        int[][] dp = new int[mat.length][mat[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        help(mat,0,0,maxa,dp);
        return maxa[0]*maxa[0];
    }
    public static int help(char[][] mat,int i,int j,int[] maxa,int[][] dp) {
        if(i  >= mat.length || j >= mat[0].length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = help(mat,i,j+1,maxa,dp);
        int diag = help(mat,i+1,j+1,maxa,dp);
        int down = help(mat,i+1,j,maxa,dp);
        
        if(mat[i][j] == '1'){
            int ans = 1+ Math.min(right,Math.min(diag,down));
            maxa[0] = Math.max(ans,maxa[0]);
            return dp[i][j] = ans;
        }else{
            return dp[i][j] =  0;
        }
    }
}