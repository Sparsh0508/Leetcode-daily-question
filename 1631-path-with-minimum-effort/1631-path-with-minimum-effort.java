class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        int[][] dist = new int[n][m];
        for(int[] rows : dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int x = curr[1];
            int y = curr[2];

            for(int[] k : dir){
                int nx = x + k[0];
                int ny = y + k[1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    int absDiff = Math.abs(grid[x][y] - grid[nx][ny]);
                    int maxDiff = Math.max(d,absDiff);
                    if(dist[nx][ny] > maxDiff){
                        dist[nx][ny] = maxDiff;
                        pq.offer(new int[]{maxDiff,nx,ny});
                    }
                }
            }
        }
        return dist[n-1][m-1]; 
    }
}