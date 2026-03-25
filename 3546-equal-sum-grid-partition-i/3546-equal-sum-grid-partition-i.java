class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long total = 0;
        long[] rows = new long[m];
        long[] cols = new long[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                total += grid[i][j];
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        if(total % 2 == 1) return false;
        long target = total/2;
        long sum =0;
        for(int i = 0;i<m;i++){
            sum += rows[i];
            if(sum == target) return true;
        }
        sum =0;
        for(int i = 0;i<n;i++){
            sum += cols[i];
            if(sum == target) return true;
        }
        return false;
    }
}