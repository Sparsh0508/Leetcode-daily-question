class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        int visit = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            visit++;

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return visit == n;



    }
}