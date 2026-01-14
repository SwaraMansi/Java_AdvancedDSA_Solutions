class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxi = 0;

        for (int num : set) {
            // start of a sequence
            if (!set.contains(num - 1)) {
                int count = 1;
                int current = num;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}
