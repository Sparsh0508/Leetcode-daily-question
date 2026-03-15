class Solution {
    // class Pair{
    //     int node;
    //     int wt;
    //     Pair(int node,int wt){
    //         this.node = node;
    //         this.wt = wt;
    //     }
    // }
    public int find(int[] par,int x){
        if(par[x] != x){
            return find(par,par[x]);
        }
        return par[x];
    }
    public void union(int[] par,int[] rank,int x,int y){
        if(rank[x] > rank[y]){
            par[x] = y;
        }else if(rank[x] < rank[y]){
            par[y] = x;
        }else{
            par[y] = x;
            rank[x]++;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        // By using krushkal
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i = 0;i<V;i++){
            for(int j = i+1;j<V;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int wt= Math.abs(x1-x2) + Math.abs(y1-y2);
                edges.add(new int[]{i,j,wt});

            }
        }
        Collections.sort(edges,(a,b)-> a[2]-b[2]);
        int[] par = new int[V];
        int[] rank = new int[V];
        for(int i = 0;i<V;i++){
            par[i] = i;
        }
        int sum = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int pu = find(par,u);
            int pv = find(par,v);

            if(pu != pv){
                sum += w;
                union(par,rank,pu,pv);
            }
        }
        return sum;

        // By using prims

        // ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // for(int i = 0;i<V;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i = 0;i<V;i++){
        //     for(int j = i+1;j<V;j++){
        //         int x1 = points[i][0];
        //         int y1 = points[i][1];

        //         int x2 = points[j][0];
        //         int y2 = points[j][1];

        //         int wt= Math.abs(x1-x2) + Math.abs(y1-y2);

        //         adj.get(i).add(new Pair(j,wt));
        //         adj.get(j).add(new Pair(i,wt));
        //     }
        // }
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        // boolean[] vis = new boolean[V];
        // pq.add(new Pair(0,0));
        // int sum = 0;
        // while(!pq.isEmpty()){
        //     Pair curr = pq.poll();
        //     int node = curr.node;
        //     int wt = curr.wt;

        //     if(vis[node]) continue;

        //     vis[node] = true;
        //     sum += wt;

        //     for(Pair nei : adj.get(node)){
        //         if(!vis[nei.node]){
        //             pq.add(new Pair(nei.node,nei.wt));
        //         }
        //     }
        // }
        // return sum;
    }
}