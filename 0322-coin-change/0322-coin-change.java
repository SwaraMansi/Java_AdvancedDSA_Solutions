class Solution {
     int INF = 1000000000;
    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = solve(n - 1, amount, coins);
        return ans >= INF ? -1 : ans;
    }

    private int solve(int i, int t, int[] coins) {

        if (t == 0) return 0;
        if (i < 0) return INF;

        if (dp[i][t] != -1)
            return dp[i][t];

        // Option 1: skip this coin
        int notTake = solve(i - 1, t, coins);

        // Option 2: take this coin (unlimited)
        int take = INF;
        if (coins[i] <= t)
            take = 1 + solve(i, t - coins[i], coins);

        return dp[i][t] = Math.min(take, notTake);
    }
}