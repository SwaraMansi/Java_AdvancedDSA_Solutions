class Solution {
    public int lengthOfLongestSubstring(String sub) {
      int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < sub.length(); right++) {
            char ch = sub.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}