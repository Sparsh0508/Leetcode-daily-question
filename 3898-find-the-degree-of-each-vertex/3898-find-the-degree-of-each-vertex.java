class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;        
        int[] degree = new int[n];

        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = 0 ; j< matrix[i].length ;j++){
                if(matrix[i][j] == 1){
                    count++;
                }
            }
            degree[i] = count; 
        }
        return degree;
    }
}