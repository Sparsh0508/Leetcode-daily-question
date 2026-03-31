class Solution {
    List<String> board;
    int n;
    int MOD= 1_000_000_007;
    int[][] dp;
    int[][] ways;
    boolean[][] vis;
    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        this.n = board.size();
        dp = new int[n][n];
        ways = new int[n][n];
        vis = new boolean[n][n];

        int[] res = help(n-1,n-1);
        if (res[1] == 0) return new int[]{0, 0};
        return res;
    }
    public int[] help(int i,int j){
        if(i < 0 || j < 0 || board.get(i).charAt(j) == 'X'){
            return new int[]{Integer.MIN_VALUE,0};
        }
        if(i== 0 && j == 0){
            return new int[]{0,1};
        }
        if(vis[i][j]){
            return new int[]{dp[i][j],ways[i][j]};
        }
        int max = Integer.MIN_VALUE;
        int totalWays = 0;
        int[][] dir = {{-1,0},{0,-1},{-1,-1}};
        for(int[] d : dir){
            int[] next = help(i + d[0],j+d[1]);
            if(next[0] == Integer.MIN_VALUE){
                continue;
            }
            if(next[0] > max){
                max = next[0];
                totalWays = next[1];
            }else if(next[0] == max){
                totalWays = (totalWays + next[1]) % MOD;
            }
        }
        if(max == Integer.MIN_VALUE){
            vis[i][j] = true;
            return new int[]{Integer.MIN_VALUE,0};
        }
        char c = board.get(i).charAt(j);
        if(c!= 'S'){
            max += c - '0';
        }
        dp[i][j] = max;
        ways[i][j] = totalWays % MOD;
        vis[i][j] = true;
        return new int[]{dp[i][j],ways[i][j]};
    }
}