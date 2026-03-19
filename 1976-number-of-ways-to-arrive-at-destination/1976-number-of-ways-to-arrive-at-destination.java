class Solution {
    int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer,List<int[]>> adj = new HashMap<>();
        for(int i = 0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge : roads){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] result = new long[n];
        int[] pathCount = new int[n];
        Arrays.fill(result, Long.MAX_VALUE);
        
        result[0] = 0;
        pathCount[0] = 1;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];
            
            if (currTime > result[currNode]) continue;
            
            for (int[] neighbor : adj.get(currNode)) {
                int adjNode = neighbor[0];
                int roadTime = neighbor[1];
                
                if (currTime + roadTime < result[adjNode]) {
                    result[adjNode] = currTime + roadTime;
                    pathCount[adjNode] = pathCount[currNode];
                    pq.offer(new long[]{result[adjNode], adjNode});
                } else if (currTime + roadTime == result[adjNode]) {
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[currNode]) % MOD;
                }
            }
        }
        
        return pathCount[n - 1];
    }
}