class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int j=1;
        int i=0;
        while(i<nums.length){
            if(nums[i]== j*k){
                j++;
            }
            else i++;
        }
        return j*k;
    }
}