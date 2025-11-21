class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) L[i] = L[i - 1] + 1;
            else L[i] = 1;
        }
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) R[i] = R[i + 1] + 1;
            else R[i] = 1;
        }

        int ans = 1;
        for (int x : L) ans = Math.max(ans, x);

        for (int i = 0; i < n; i++) {

            int left = (i > 0) ? L[i - 1] : 0;
            int right = (i < n - 1) ? R[i + 1] : 0;

            if (i > 0 && i < n - 1 && nums[i - 1] <= nums[i + 1]) {
                ans = Math.max(ans, left + 1 + right);
            } else {
                ans = Math.max(ans, Math.max(left + 1, right + 1));
            }
        }

        return ans;
    }
    
}