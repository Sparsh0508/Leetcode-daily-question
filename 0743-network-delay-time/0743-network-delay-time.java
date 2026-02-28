class Solution {
    static class Pair{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v,w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);

        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDist = curr.dist;

            if (currDist > dist[currNode]) continue;

            for(Pair nei : adj.get(currNode)){
                int adjNode = nei.node;
                int wei = nei.dist;

                if(currDist + wei < dist[adjNode]){
                    dist[adjNode] = currDist + wei;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            } 
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}