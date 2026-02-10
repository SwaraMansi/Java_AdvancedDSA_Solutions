class Solution {
    public boolean canPartition(int[] nums) {
         int sum=0;
         for(int x:nums){
            sum+=x;
         }
         int target=sum/2;
         if(sum%2 != 0) return false;
         else 
         return solve(nums.length,target,nums);
    }
    public boolean solve(int n, int target, int[] arr) {
      boolean[][] dp= new boolean[n+1][target+1];
      for(int i=0;i<=n;i++){
        dp[i][0]= true;
      }
      for(int i=1;i<=n;i++){
        for(int t=1;t<=target;t++){
           if (arr[i - 1] <= t) {
            dp[i][t]= dp[i-1][t] || dp[i-1][t-arr[i-1]];
           }
         else {
            dp[i][t] = dp[i - 1][t];
            }
        }
      }
      return dp[n][target];
    }
}