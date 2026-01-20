class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxi = 0;   
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                maxi = Math.max(maxi, count);
            } 
            else if (c == ')') {
                count--;
            }
        }
     return maxi;
    }
}