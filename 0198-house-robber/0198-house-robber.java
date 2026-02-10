class Solution {
    public int rob(int[] nums) {
          int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return recur(nums, dp, n - 1);
    }

    private int recur(int[] nums, int[] dp, int index) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + recur(nums, dp, index - 2);

        int nopick = recur(nums, dp, index - 1);

        return dp[index] = Math.max(pick, nopick);
    }
}   