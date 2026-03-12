class Solution {    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;

        int level = 1;

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if(x == n-1 && y == n-1){
                    return level;
                }

                for(int[] d : dir){

                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0){
                        q.offer(new int[]{nx,ny});
                        grid[nx][ny] = 1;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}