class Solution {
    int[] rank;
    int[] par;

    public int find(int x){
        if(x != par[x]){
            par[x] = find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par) return;

        if(rank[x_par] < rank[y_par]){
            par[x_par] = y_par;
        }else if(rank[x_par] > rank[y_par]){
            par[y_par] = x_par;
        }else{
            par[y_par] = x_par;
            rank[x_par]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        for(int i = 0;i<26;i++){
            par[i] = i;
            rank[i] = 1;
        }

        for(String s : equations){
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                char first = s.charAt(0);
                char sec = s.charAt(3);

                int par_first = find(first-'a');
                int par_sec = find(sec-'a');
                if(par_first == par_sec){
                    return false;
                }
            }
        }
        return true;
    }
}