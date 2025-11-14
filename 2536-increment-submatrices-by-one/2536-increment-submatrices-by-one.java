class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
        int[][] arr = new int[n][n];
        for(int i = 0;i<q.length;i++){
            int row1 = q[i][0];
            int col1 = q[i][1];
            int row2 = q[i][2];
            int col2 = q[i][3];
            for(int j = row1;j<=row2;j++){
                for(int k = col1;k<=col2;k++){
                    arr[j][k]++;
                }
            }
        }
        return arr;
    }
}