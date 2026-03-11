class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] req, int[][] q) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : req){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0;i<q.length;i++){
            int src = q[i][0];
            int dest = q[i][1];
            boolean isPath = check(adj,src,dest,n);
            res.add(isPath);
        }
        return res;
    }
    public static boolean check(ArrayList<ArrayList<Integer>> adj,int src,int dest,int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            if(u == dest){
                return true;
            }
            for(int nei : adj.get(u)){
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei] = true;
                }
            }
        }
        return false;
    }
}