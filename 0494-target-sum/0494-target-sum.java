class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int totalSum = 0;
        for (int x : nums) totalSum += x;

        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0)
            return 0;

        int S = (totalSum + target) / 2;

        int[] dp = new int[S + 1];
        dp[0] = 1;   

        for (int num : nums) {
            for (int s = S; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[S];
    }
}