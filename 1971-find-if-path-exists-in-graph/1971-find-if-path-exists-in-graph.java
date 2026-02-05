class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }    
        for(int[] i : edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        return bfs(graph,src,dest);
    }
    public static boolean bfs(List<List<Integer>> graph,int src,int dest){
        boolean[] visit = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visit[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest){
                return true;
            }
            for(int i : graph.get(node)){
                if(!visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
        return false;
    }
}   