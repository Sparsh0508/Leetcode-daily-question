class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // public boolean dfs(int[][] graph, int node, int[] color, int curr) {
    //     color[node] = curr;

    //     for (int v : graph[node]) {
    //         if (color[v] == -1) {
    //             if (!dfs(graph, v, color, 1 - curr)) {
    //                 return false;
    //             }
    //         } else if (color[v] == curr) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static boolean bfs(int[][] graph, int node, int[] color, int curr){
        Queue<Integer> q= new LinkedList<>();
        q.add(node);

        color[node] = curr;

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                if(color[v] == color[u]){
                    return false;
                }
                if(color[v] == -1){
                    color[v] = 1- color[u];
                    q.add(v);
                }
            }
        }
        return true;
    }
}