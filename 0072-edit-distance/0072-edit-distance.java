class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(n - 1, m - 1, word1, word2, dp);
    }

    private int solve(int i, int j, String w1, String w2, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = solve(i - 1, j - 1, w1, w2, dp);
        }

        int insert = solve(i, j - 1, w1, w2, dp);
        int delete = solve(i - 1, j, w1, w2, dp);
        int replace = solve(i - 1, j - 1, w1, w2, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}