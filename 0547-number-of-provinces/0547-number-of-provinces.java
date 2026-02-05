class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!visit[i]){
                dfs(adj,i,visit);
                count++; 
            }
        }
        return count;
    }
    public static void dfs(HashMap<Integer,ArrayList<Integer>> adj,int node,boolean[] visit){
        visit[node] = true;

        for(int v : adj.get(node)){
            if(!visit[v]){
                dfs(adj,v,visit);
            }
        } 
    }
}