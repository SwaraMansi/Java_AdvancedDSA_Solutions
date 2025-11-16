class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int a= nums[0];
        int b=nums[nums.length-2];
        int c= nums[nums.length-1];
        int ans= c+b-a;
        return ans;
        }
}