class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> res= new ArrayList<>();
   char[][] board= new char[n][n];
   for(int i=0;i<n;i++){
        Arrays.fill(board[i],'.');
   }
   backtrack(n,res,0,board);
   return res;
 }
        private static void backtrack(int n, List<List<String>> res,int row,char[][] board){
            if(row==n){
                res.add(construct(board));
            }
            for(int col=0;col<board.length;col++){
                if(isSafe(board,row,col)){
                    board[row][col]='Q';
                    backtrack(n,res,row+1,board);
                    board[row][col]='.';
                }
            }
        }
    private static boolean isSafe(char[][] board, int row, int col) {
  
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
   
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
        private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}