class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        int[] col = new int[n];
        Arrays.fill(col,-1);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans[j][i] = matrix[j][i];
                col[i] = Math.max(col[i],matrix[j][i]);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(ans[j][i] == -1){
                    ans[j][i] = col[i];
                }
            }
        }
        return ans;
    }
}