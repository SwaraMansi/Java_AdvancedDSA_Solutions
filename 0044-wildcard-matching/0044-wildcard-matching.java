class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m]; // -1 = unvisited

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(n - 1, m - 1, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, int[][] dp) {
        // base cases
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        // match or '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean res = solve(i - 1, j - 1, s, p, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        // '*'
        if (p.charAt(j) == '*') {
            boolean res = solve(i, j - 1, s, p, dp) || 
                          solve(i - 1, j, s, p, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        dp[i][j] = 0;
        return false;
    }
}