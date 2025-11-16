class Solution {
    public int numSub(String s) {
       long sum = 0;
        long count = 0;
        long mod = 1_000_000_007;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;    
            } else {
                sum = (sum + count * (count + 1) / 2) % mod;
                count = 0;  
            }
        }

        sum = (sum + count * (count + 1) / 2) % mod;

        return (int) sum;
    }
}