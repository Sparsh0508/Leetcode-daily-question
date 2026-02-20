class Solution {
    int need = 0;
    public int minIncrements(int n, int[] cost) {
        solve(1,n,cost);
        return need;
    }
    public int solve(int curr, int n, int[]cost){
        if(curr>n) return 0;
        int leftSide = solve(2*curr,n,cost);
        int rightSide = solve(2*curr+1,n,cost);
        need+= Math.abs(leftSide-rightSide);
        return Math.max(leftSide,rightSide)+cost[curr-1];

    }
}