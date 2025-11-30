class Solution {
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        return solve(0, 0, triangle);
    }

    private int solve(int row, int col, List<List<Integer>> tr) {
        if (row == tr.size() - 1) return tr.get(row).get(col);

        if (dp[row][col] != null) return dp[row][col];

        int down = solve(row + 1, col, tr);
        int diag = solve(row + 1, col + 1, tr);

        return dp[row][col] = tr.get(row).get(col) + Math.min(down, diag);
    }
}
