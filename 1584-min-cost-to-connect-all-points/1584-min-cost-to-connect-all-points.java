class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<V;i++){
            for(int j = i+1;j<V;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int wt= Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new Pair(j,wt));
                adj.get(j).add(new Pair(i,wt));
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.wt;

            if(vis[node]) continue;

            vis[node] = true;
            sum += wt;

            for(Pair nei : adj.get(node)){
                if(!vis[nei.node]){
                    pq.add(new Pair(nei.node,nei.wt));
                }
            }
        }
        return sum;
    }
}