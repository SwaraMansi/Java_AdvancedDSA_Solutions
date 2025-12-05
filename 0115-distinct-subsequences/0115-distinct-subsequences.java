class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, t, 0, 0, dp);
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1;  
        if (i == s.length()) return 0;    
        if (dp[i][j] != -1) return dp[i][j];

        long ways = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ways += helper(s, t, i + 1, j + 1, dp);  
        }
        ways += helper(s, t, i + 1, j, dp);

        return dp[i][j] = (int) ways;
    }
}
