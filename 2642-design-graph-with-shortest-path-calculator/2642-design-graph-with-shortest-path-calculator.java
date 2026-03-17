class Graph {
    int[][] dist;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        dist = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i == j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = Math.min(dist[u][v],w);
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        if(w >= dist[u][v]) return;

        dist[u][v] = w;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dist[i][u] != Integer.MAX_VALUE && dist[v][j] != Integer.MAX_VALUE){
                    dist[i][j] = Math.min(dist[i][j], dist[i][u] + w + dist[v][j]);
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        if(dist[node1][node2] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */