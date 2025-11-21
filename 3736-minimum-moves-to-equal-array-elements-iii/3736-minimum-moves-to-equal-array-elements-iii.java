class Solution {
    public int minMoves(int[] nums) {
        int maxi= nums[0],sum=0;
        for(int num:nums){
            maxi=Math.max(maxi,num);
        }
        for(int num:nums){
            sum+=(maxi-num);
        }
        return sum;
    }
}