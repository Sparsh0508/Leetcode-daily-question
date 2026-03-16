class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        boolean[][] reach = new boolean[n][n];

        for(int[] p : pre){
            reach[p[0]][p[1]] = true;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(reach[i][k] && reach[k][j]){
                        reach[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            ans.add(reach[q[0]][q[1]]);
        }
        return ans;
    }
}