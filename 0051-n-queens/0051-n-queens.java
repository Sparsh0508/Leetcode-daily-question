class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

         for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> results = new ArrayList<>();
        nQueens(board,0,results);
        return results;
    }
    public static void nQueens(char[][] board,int rows,List<List<String>> results){
        // base case
        if(rows == board.length){
            results.add(constructBoard(board));
            return;
        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(board,rows,j)){
                board[rows][j] = 'Q';
                nQueens(board,rows+1,results);
                board[rows][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int rows,int col){
        //vertically up
        for(int i = rows-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // up left
        for(int i = rows-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // up right
        for(int i = rows-1,j = col+1;i>=0 && j< board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}