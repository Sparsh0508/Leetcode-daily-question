class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] dist = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i==j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];

            dist[a][b] = Math.min(dist[a][b],w);
            dist[b][a] = Math.min(dist[b][a],w);
        }
        for(int k = 0;k<n;k++){
            for(int i= 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int city = -1;
        for(int i = 0;i<n;i++){
            int c = 0;
            for(int j = 0;j<n;j++){
                if(i != j && dist[i][j] <= t){
                    c++;
                }
            }
            if(c<=min){
                min = c;
                city = i;
            }
        }
        return city;
    }
}