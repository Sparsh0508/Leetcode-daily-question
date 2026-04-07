class Solution {
    class Pair{
        int node;
        double dist;

        Pair(int node,double dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int dest) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        double[] dist = new double[n];
        int[] par = new int[n];

        Arrays.fill(dist,0.0);
        dist[src] = 1.0;
        
        pq.add(new Pair(src,1.0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            double currProb = curr.dist;
            if (currProb < dist[u]) continue;
            for(Pair nei : adj.get(u)){
                int v = nei.node;
                double newProb = nei.dist * currProb;
                if(newProb > dist[v]){
                    dist[v] = newProb;
                    pq.add(new Pair(v,newProb));
                }
            }
        }
        return dist[dest];
    }
}