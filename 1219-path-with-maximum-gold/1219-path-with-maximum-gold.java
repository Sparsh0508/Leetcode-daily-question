class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, help(grid, i, j));
                }
            }
        }
        return ans;
    }
    public static int help(int[][] grid,int r,int c){
        if(r<0 || c< 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        int gold = grid[r][c];
        grid[r][c] = 0;


        int up = help(grid,r-1,c);
        int down = help(grid,r+1,c);

        int right = help(grid,r,c+1);
        int left = help(grid,r,c-1);

        grid[r][c] = gold;
        return gold + Math.max(up,Math.max(down,Math.max(right,left)));
    }
}