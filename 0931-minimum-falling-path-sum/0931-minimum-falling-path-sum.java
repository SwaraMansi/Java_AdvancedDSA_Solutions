class Solution {
    int rows, cols;
    Integer[][] dp;

    public int minFallingPathSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new Integer[rows][cols];

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < cols; c++) {
            ans = Math.min(ans, dfs(grid, 0, c));
        }

        return ans;
    }

    public int dfs(int[][] grid, int r, int c) {

        if (c < 0 || c >= cols) return Integer.MAX_VALUE; 
        if (r == rows - 1) return grid[r][c]; 

        if (dp[r][c] != null) return dp[r][c];

        int down = dfs(grid, r + 1, c);
        int left = dfs(grid, r + 1, c - 1);
        int right = dfs(grid, r + 1, c + 1);

        return dp[r][c] = grid[r][c] + Math.min(down, Math.min(left, right));
    }
}

