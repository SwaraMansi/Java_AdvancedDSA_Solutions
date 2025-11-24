class Solution {
    public long sumAndMultiply(int n) {

        long newNum = 0;
        long sum = 0;

        String s = String.valueOf(n);

        for (char ch : s.toCharArray()) {
            if (ch != '0') {
                int digit = ch - '0';
                newNum = newNum * 10 + digit; 
                sum += digit;
            }
        }

        return newNum * sum;
    }
}
