class Solution {
    class Pair{
        int node;
        int cost;
        int stops;
        Pair(int node,int cost,int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;
            if(stops > k){
                continue;
            }

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int price = nei[1];

                if(cost + price < dist[next]){
                    dist[next] = cost + price;
                    q.add(new Pair(next,dist[next],stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}