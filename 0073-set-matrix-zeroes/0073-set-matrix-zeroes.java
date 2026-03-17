class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> al = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    al.add(new int[]{i,j});
                }
            }
        }
        for(int[] q : al){
            int a = q[0];
            int b = q[1];
            Arrays.fill(matrix[a],0);
            for(int i = 0; i < n; i++){
                matrix[i][b] = 0;
            }
        }

    }
}