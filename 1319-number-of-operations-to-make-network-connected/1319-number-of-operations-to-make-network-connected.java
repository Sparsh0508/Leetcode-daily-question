class Solution {
    static int[] rank;
    static int[] par;

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int x,int y){
        int x_par = find(x);
        int y_par = find(y);
        if(x_par == y_par){
            return;
        }
        if(rank[x_par] > rank[y_par]){
            par[y_par] = x_par;
        }
        else if(rank[x_par] < rank[y_par]){
            par[x_par] = y_par;
        }
        else{
            par[y_par] = x_par;
            rank[x_par]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        par = new int[n];
        rank = new int[n];
        if(connections.length < n-1){
            return -1;
        }
        for(int i = 0;i<n;i++){
            par[i] = i;
        }
        int comp = n;
        for(int[] edge : connections){
            if(find(edge[0]) != find(edge[1])){
                union(edge[0],edge[1]);
                comp--;
            }
        }
        return comp-1;
    }
}