class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0 ;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        long ans = 0;
        long size = 0;
        long rem = n;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                size = dfs(vis,graph,i);
                ans += size * (rem-size);
                rem -= size;
            }
        }
        return ans;
    }
    public static long dfs(boolean[] vis,List<List<Integer>> graph ,int node){
        vis[node] = true;

        long cnt = 1;
        for(int v : graph.get(node)){
            if(!vis[v]){
                cnt+= dfs(vis,graph,v);
            }
        }
        return cnt;
    }
}