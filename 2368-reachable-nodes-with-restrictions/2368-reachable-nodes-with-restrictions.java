class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> hs = new HashSet<>();
        for (int r : restricted) hs.add(r);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        return dfs(0, adj, hs, vis);
    }

    public int dfs(int node, ArrayList<ArrayList<Integer>> adj,
                   HashSet<Integer> hs, boolean[] vis) {

        if (hs.contains(node)) return 0;

        vis[node] = true;
        int count = 1; 

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                count += dfs(nei, adj, hs, vis);
            }
        }
        return count;
    }
}