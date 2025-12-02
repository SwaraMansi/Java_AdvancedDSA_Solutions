class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) total += x;

        if ((total + target) % 2 != 0 || total < Math.abs(target)) 
            return 0;

        int sum = (total + target) / 2;

        return countSubsets(nums, sum);
    }

    private int countSubsets(int[] nums, int sum) {
        int n = nums.length;

        int[][] dp = new int[n][sum + 1];

        if (nums[0] == 0) dp[0][0] = 2; 
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= sum)
            dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= sum; s++) {

                int notTake = dp[i - 1][s];

                int take = 0;
                if (nums[i] <= s) take = dp[i - 1][s - nums[i]];

                dp[i][s] = notTake + take;
            }
        }

        return dp[n - 1][sum];
    }
}
