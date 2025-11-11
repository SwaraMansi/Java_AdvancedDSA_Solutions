import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Traverse and merge
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlapping → extend the end
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → push current and move ahead
                result.add(current);
                current = next;
            }
        }

        // Add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
