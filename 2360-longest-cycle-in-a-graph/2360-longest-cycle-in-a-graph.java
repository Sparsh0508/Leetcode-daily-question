class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            int u = i;
            int v = edges[i];
            if(v != -1){
                al.get(u).add(v);
            }
        }
        int max = -1;
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dist[i] = 0;
                max = Math.max(max,help(al,vis,i,dist));
            }
        }
        return max ;
    }
    public static int help(ArrayList<ArrayList<Integer>> edge,boolean[] vis,int node,int[] dist){
        vis[node] = true;
        int len = -1;
        for(int nei : edge.get(node)){
            if(!vis[nei]){
                dist[nei] = dist[node] + 1;
                len = Math.max(len,help(edge,vis,nei,dist));
            }
            else if(dist[nei] != -1){
                len = Math.max(len,dist[node] - dist[nei] +1);
            }
        }
        dist[node] = -1;
        return len;

    }
}