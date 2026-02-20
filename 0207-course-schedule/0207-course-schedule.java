class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] inRecursion = new boolean[n];
        boolean [] visit = new boolean[n]; 
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }
        for(int i = 0;i<n;i++){
            if(!visit[i] && isCycleDetect(adj,i,visit,inRecursion)){
                return false;
            }
        }
        return true;
    }
    public static boolean isCycleDetect(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visit,boolean[] inRecursion){  
        visit[node] = true;
        inRecursion[node] = true;

        for(int nei : adj.get(node)){
            if(!visit[nei] && isCycleDetect(adj,nei,visit,inRecursion)) {
                return true;
            }else if(inRecursion[nei]){
                return true;
            }
        }
        inRecursion[node] = false;
        return false;
    }
}