class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private  static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            int rightNum = nums[right];
            count.put(rightNum, count.getOrDefault(rightNum, 0) + 1);

          //  if (count.get(rightNum) == 1) {
            //    k--; 
            //}

            while (count.size() >k) {
                int leftNum = nums[left];
                count.put(leftNum, count.get(leftNum) - 1);
                if (count.get(leftNum) == 0) {
                    count.remove(leftNum);
                }
                left++;
            }

            result += (right - left + 1); 
        }

        return result;
    }

    }