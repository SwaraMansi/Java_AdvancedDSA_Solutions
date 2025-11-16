class Solution {
    public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (x, y) -> (x[1] - x[0]) - (y[1] - y[0]));

        int n = costs.length / 2;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += costs[i][1];
        }

        for (int i = n; i < 2 * n; i++) {
            total += costs[i][0];
        }

        return total;
    }
}