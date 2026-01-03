import java.util.*;

class Solution {
    public int minLength(int[] nums, int k) {
        int[] res = nums;

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int distinctSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < res.length; right++) {

            int val = res[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            if (freq.get(val) == 1) {
                distinctSum += val;
            }
            while (distinctSum >= k) {
                minLen = Math.min(minLen, right - left + 1);

                int remove = res[left];
                freq.put(remove, freq.get(remove) - 1);

                if (freq.get(remove) == 0) {
                    distinctSum -= remove;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
