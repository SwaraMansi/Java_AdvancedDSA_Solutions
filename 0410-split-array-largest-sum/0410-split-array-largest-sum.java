class Solution {
    public int splitArray(int[] nums, int k) {
        int n= nums.length;
         if (k> n) return -1;

        int low = 0, high = 0;

        for (int pages : nums) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;   
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int maxi) {
        int students = 1;
        int currSum = 0;

        for (int pages : nums) {
            if (currSum + pages <= maxi) {
                currSum += pages;
            } else {
                students++;
                currSum = pages;
                if (students > k) return false;
            }
        }
        return true;
    }
}