class Solution {
       private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) return res;

        backtrack(digits, res, new StringBuilder(), 0);
        return res;
    }

    private static void backtrack(String digits, ArrayList<String> res, StringBuilder sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, res, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}