class Solution {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
         int[][] dp= new int[m][n];
 dp[0][0] = grid[0][0];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if (i == 0 && j == 0) continue;
            
              int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
            if(i>0)
            down= + dp[i-1][j];
            if(j>0)
            right=  dp[i][j-1];
            dp[i][j] = grid[i][j]+ Math.min(down, right);
        }
    }
    return dp[m-1][n-1];
    }
}