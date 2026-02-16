class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
          Arrays.sort(arr);
          int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
            for (int j = 0; j < n ; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(
                        nums[j], nums[left], nums[right] ));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}