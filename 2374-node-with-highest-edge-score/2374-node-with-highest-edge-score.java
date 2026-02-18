class Solution {
    public int edgeScore(int[] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = i;
            int v = edges[i];

            adj.get(v).add(u);
        }
        System.out.print(adj);
        long max = 0;
        int ans = 0;
        for(int i= 0;i<adj.size();i++){
            long sum = 0;
            for(int j = 0;j<adj.get(i).size();j++){
               sum += adj.get(i).get(j); 
            }
            if(sum > max){
                max = sum;
                ans = i;
            }
        }
        return ans;   
    }
}