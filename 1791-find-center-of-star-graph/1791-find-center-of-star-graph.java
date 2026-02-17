class Solution {
    public int findCenter(int[][] edges) {
        int[] count = new int[edges.length+2];
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            count[u]++;
            count[v]++;
        }
        for(int i=1;i<count.length;i++){
            if(count[i] == edges.length){
                return i;
            }
        }
        return -1;
    }
}