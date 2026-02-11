class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;

        int[][][] dp = new int[n][k + 1][2];

        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        dp[0][0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {

                if (j > 0) {
                    dp[i][j][0] = Math.max(dp[i-1][j][0],
                                           dp[i-1][j][1] + prices[i]);
                }

               

                if (j > 0) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1],
                                           dp[i-1][j-1][0] - prices[i]);
                }
            }
        }

        return dp[n-1][k][0];
    }
}
