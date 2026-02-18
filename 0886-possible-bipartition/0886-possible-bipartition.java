class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : dislikes){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] colors = new int[n+1];
        Arrays.fill(colors,-1);
        for(int i = 1;i<=n;i++){
            if(colors[i] == -1){
                if(!check(adj,colors,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean check(List<List<Integer>> adj,int[] colors,int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        colors[node] = 1;

        while(!q.isEmpty()){
            int u = q.poll();

            for(int i : adj.get(u)){
                if(colors[i] == colors[u]){
                    return false;
                }else if(colors[i] == -1){
                    q.add(i);
                    colors[i] = 1 - colors[u];
                }
            }
        }
        return true;
    }

}