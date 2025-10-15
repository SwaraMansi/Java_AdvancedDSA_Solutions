class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }
        int windowSize = n - k;
        int minWindowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            minWindowSum += cardPoints[i];
        }

        int currentWindowSum = minWindowSum;

        for (int i = windowSize; i < n; i++) {
            currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }

        return totalSum - minWindowSum;
    }
}
