import java.util.*;

class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] res = diff;
        long[] max = new long[n];
        Arrays.fill(max, Long.MAX_VALUE);

        max[0] = 0;

        for (int[] r : restrictions) {
            int idx = r[0];
            int val = r[1];
            max[idx] = Math.min(max[idx], val);
        }
        for (int i = 1; i < n; i++) {
            max[i] = Math.min(max[i], max[i - 1] + res[i - 1]);
        }
    
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.min(max[i], max[i + 1] + res[i]);
        }
        long ans = 0;
        for (long v : max) {
            ans = Math.max(ans, v);
        }

        return (int) ans;
    }
}
