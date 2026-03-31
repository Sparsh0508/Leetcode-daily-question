class Solution { 
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new Integer[rows][cols][cols];
        return helper(grid, 0, 0, cols - 1);
    }  

    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {
        if(robotACol < 0 || robotBCol < 0 || 
           robotACol >= grid[0].length || robotBCol >= grid[0].length) {
            return 0;
        }
        if(currRow == grid.length) {
            return 0;
        }
        if(dp[currRow][robotACol][robotBCol] != null) {
            return dp[currRow][robotACol][robotBCol];
        }

        int result = 0;
        if(robotACol == robotBCol) {
            result += grid[currRow][robotACol];
        } else {
            result += grid[currRow][robotACol] + grid[currRow][robotBCol];
        }

        int max = 0;
        for(int x = robotACol - 1; x <= robotACol + 1; x++) {
            for(int y = robotBCol - 1; y <= robotBCol + 1; y++) {
                max = Math.max(max, helper(grid, currRow + 1, x, y));
            }
        }

        result += max;

        return dp[currRow][robotACol][robotBCol] = result;
    }
}