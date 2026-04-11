class Solution {
    public int maxProfit(int[] nums) {
        int buy=nums[0];
        int profit=0;
 for(int i=0;i<nums.length;i++) {
    if(buy>nums[i]){
        buy=nums[i];
    }
    profit= Math.max(profit, nums[i]-buy);
 }      
 return profit;
    }
}