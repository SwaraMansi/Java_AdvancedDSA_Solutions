class Solution {
    public int[] twoSum(int[] nums, int target) {
       for(int left=0; left<nums.length-1;left++){
       int right= nums.length-1;
       while(right>left){
        if(nums[left]+nums[right]==target){
        return new int[]{left,right};
        }
        else{
            right--;
        }
       }}
       return new int[]{-1,-1};
    }
}