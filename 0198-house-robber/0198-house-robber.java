class Solution {
    public int rob(int[] nums) {
       int n= nums.length;
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
       return recur(nums,dp,n); 
    }
    private int recur(int[] nums , int[] dp, int index){
        if(index==1){ 
            dp[index]= nums[0];
        return nums[0];
        }
        if(index==0){
            dp[0]=0;
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        int pick = nums[index-1] + recur(nums,dp,index-2);
        int nopick= 0+ recur(nums,dp, index-1);
        dp[index]= Math.max(pick,nopick);
        return dp[index]; 
    }
}