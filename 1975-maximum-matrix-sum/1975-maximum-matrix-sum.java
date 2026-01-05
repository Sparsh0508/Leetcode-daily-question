class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int negCnt = 0;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) {
                    negCnt++;
                }
                minVal = Math.min(minVal, Math.abs(value));
            }
        }

        if (negCnt % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2 * minVal;
        }
    }
}