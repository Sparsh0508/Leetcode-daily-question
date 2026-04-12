class Solution {
    static Integer[][][][][] dp;
    public int minimumDistance(String word) {
        dp = new Integer[301][7][7][7][7];
        return solve(word,0,-1,-1,-1,-1);
    }
    public static int solve(String word,int i,int x1,int y1,int x2,int y2){
        if(i >= word.length()){
            return 0;
        }
        if(dp[i][x1+1][y1+1][x2+1][y2+1] != null){
            return dp[i][x1+1][y1+1][x2+1][y2+1];
        }
        int[] pair = getCord(word.charAt(i));
        int x = pair[0];
        int y = pair[1];
        if(x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1){
            return dp[i][x1+1][y1+1][x2+1][y2+1] = solve(word,i+1,x,y,x2,y2);
        }
        if(x2 == -1 && y2 == -1){
            int move1 = solve(word,i+1,x1,y1,x,y);
            int move2 = getDist(x1,y1,x,y) + solve(word,i+1,x,y,x2,y2);
            return dp[i][x1+1][y1+1][x2+1][y2+1] = Math.min(move1,move2);
        }
        
        int move1 = getDist(x1,y1,x,y) + solve(word,i+1,x,y,x2,y2);
        int move2 = getDist(x2,y2,x,y) + solve(word,i+1,x1,y1,x,y);
        return dp[i][x1+1][y1+1][x2+1][y2+1] = Math.min(move1,move2);
    }
    public static int[] getCord(char ch){
        int curr = ch -'A'; 
        return new int[]{curr/6,curr%6};
    }
    public static int getDist(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}