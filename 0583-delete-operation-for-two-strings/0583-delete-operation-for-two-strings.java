class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int lcs = LCS(m-1, n-1, word1, word2, dp);
        return m + n - 2 * lcs;  
    }

    private int LCS(int i, int j, String a, String b, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + LCS(i - 1, j - 1, a, b, dp);
        } else {
            return dp[i][j] = Math.max(
                LCS(i - 1, j, a, b, dp),
                LCS(i, j - 1, a, b, dp)
            );
        }
    }
}
