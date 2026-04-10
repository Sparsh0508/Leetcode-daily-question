class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'X'){
                    dfs(board,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == '.'){
            return;
        }
        grid[i][j] = '.';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}