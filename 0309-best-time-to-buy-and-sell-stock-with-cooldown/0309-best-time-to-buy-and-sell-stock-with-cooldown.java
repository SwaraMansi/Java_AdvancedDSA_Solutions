class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][3];
        return solve(0, 1, prices);  
    }

    public int solve(int i, int state, int[] prices) {
        if (i >= prices.length) return 0;

        if (dp[i][state] != null) return dp[i][state];

        int profit;

        if (state == 1) {

            int buy = -prices[i] + solve(i + 1, 0, prices);  
            int skip = solve(i + 1, 1, prices);             
            profit = Math.max(buy, skip);
        }
        else if (state == 0) {
            int sell = prices[i] + solve(i + 1, 2, prices);  
            int skip = solve(i + 1, 0, prices);         
            profit = Math.max(sell, skip);
        }
        else {
            profit = solve(i + 1, 1, prices);         
        }

        return dp[i][state] = profit;
    }
}
