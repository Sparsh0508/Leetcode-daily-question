class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }
    public static int dfs(int[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }
        int cnt = 0;
        grid[i][j] = -1;
        cnt += dfs(grid,i+1,j);
        cnt += dfs(grid,i,j+1);
        cnt += dfs(grid,i-1,j);
        cnt += dfs(grid,i,j-1);
        return cnt;
    }
}