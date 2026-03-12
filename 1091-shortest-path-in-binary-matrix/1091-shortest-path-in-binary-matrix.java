class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0)
            return -1;

        int[][] dist = new int[n][n];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer(new int[]{1,0,0});
        dist[0][0] = 1;

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int d = curr[0];
            int x = curr[1];
            int y = curr[2];

            if(x == n-1 && y == n-1)
                return d;

            for(int[] k : dir){

                int nx = x + k[0];
                int ny = y + k[1];

                if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0){

                    if(d + 1 < dist[nx][ny]){
                        dist[nx][ny] = d + 1;
                        pq.offer(new int[]{d+1, nx, ny});
                    }

                }
            }
        }

        return -1;
    }
}