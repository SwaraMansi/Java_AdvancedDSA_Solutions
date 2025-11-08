class Solution {
    public int longestBalanced(String s) {
            int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isBalanced(Map<Character, Integer> freq) {
        Set<Integer> set = new HashSet<>(freq.values());
        return set.size() == 1; 
    }
}