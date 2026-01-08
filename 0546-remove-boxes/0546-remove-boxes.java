class Solution {

    public int[][][] memo;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        memo = new int[n][n][n];
        return dp(boxes, 0, n - 1, 0);
    }

    public int dp(int[] boxes, int l, int r, int k) {
        
        if (l > r) return 0;
        
        if (memo[l][r][k] != 0) return memo[l][r][k];
        
        while (l + 1 <= r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }
        
        int res = (k + 1) * (k + 1) + dp(boxes, l + 1, r, 0);
        
        for (int m = l + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                
                res = Math.max(
                    res,
                    dp(boxes, l + 1, m - 1, 0) + dp(boxes, m, r, k + 1)
                );
            }
        }

        memo[l][r][k] = res;
        return res;
    }
}
