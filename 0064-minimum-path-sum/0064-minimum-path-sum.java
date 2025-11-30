class Solution {
      int rows, cols;
    public int minPathSum(int[][] grid) {
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

        if (r >= rows || c >= cols) return Integer.MAX_VALUE;
        if(r==rows-1 && c==cols-1) {
            return grid[r][c]; 
        }
        
        if(dp[r][c] != -1) return dp[r][c];
        int down=  dfs(grid,r+1,c,dp);
        int right=dfs(grid,r,c+1,dp);

        return dp[r][c] =grid[r][c] + Math.min(down,right);
    }
}
