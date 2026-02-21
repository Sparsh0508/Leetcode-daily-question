class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int[] color, int curr) {
        color[node] = curr;

        for (int v : graph[node]) {
            if (color[v] == -1) {
                if (!dfs(graph, v, color, 1 - curr)) {
                    return false;
                }
            } else if (color[v] == curr) {
                return false;
            }
        }
        return true;
    }
}