class Solution {
    public int maxBalancedSubarray(int[] nums) {

        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int px = 0;             
        int diff = 0;            
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            px ^= nums[i];
            if (nums[i] % 2 == 0) diff++;
            else diff--;

            String key = px + "#" + diff;

            if (map.containsKey(key)) {
                int prevIndex = map.get(key);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }
}
