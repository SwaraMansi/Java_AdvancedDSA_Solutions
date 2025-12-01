class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);

        int maxlen = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev]) {
                    lis[i] = Math.max(lis[i], 1 + lis[prev]);
                }
            }
            maxlen = Math.max(maxlen, lis[i]);
        }
        return maxlen;
    }
}
