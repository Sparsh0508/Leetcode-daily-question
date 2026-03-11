class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        // return dfs(graph,vis,n,source,destination);
        return bfs(graph,vis,n,source,destination);
    }
    // public static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis ,int n,int src,int dest){
    //     if(src == dest){
    //         return true;
    //     }
    //     vis[src] = true;
    //     for(int nei : graph.get(src)){
    //         if(!vis[nei]){
    //             if(dfs(graph,vis,n,nei,dest)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean bfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis ,int n,int src,int dest){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest){
                return true;
            }
            for(int nei : graph.get(node)){
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei] = true;
                }
            }
        }
        return false;
    }

}