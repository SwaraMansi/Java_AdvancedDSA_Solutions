class Solution {
    int result = 0;
    int rows, cols;

    public int uniquePathsWithObstacles(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
      int[][] dp= new int[rows+1][cols+1];
       for(int i=0;i<rows+1;i++){
            for(int j=0;j<cols+1;j++){
                dp[i][j]=-1;
            }
        }
        return dfs(grid, 0, 0,dp);
        }

    public int dfs(int[][] grid, int r, int c,int[][] dp) {
      
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 1) {
            dp[r][c]=0;
            return 0;
        }
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            dp[r][c]=0;
            return 0;
        }
        if(r==rows-1 && c==cols-1) {
            dp[r][c]=1;
            return 1; 
        }
         if(dp[r][c] != -1) return dp[r][c];
        int ways=dfs(grid, r + 1, c,dp) +dfs(grid, r, c + 1,dp);
        return dp[r][c]= ways;
    }
}
