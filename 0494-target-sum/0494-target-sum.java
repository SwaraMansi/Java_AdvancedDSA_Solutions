class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int total=0;
       for(int x:nums){
        total += x;
       }
       if(total+target%2!=0 || total<Math.abs(target)){
        return 0;
       }
       int sum= total+target/2;
       return countsubsets(nums, sum);
    }
    private int countsubsets(int[] nums,int sum){
        int n=nums.length;
        int[][] dp=new int[n][sum+1];
        if(nums[0]==0) dp[0][0]=2;
        else  dp[0][0]=1;
         if (nums[0] != 0 && nums[0] <= sum)
            dp[0][nums[0]] = 1;

        for(int i=1;i<n;i++){
            
            for(int j=1;j<=sum;j++){
                int take=0;
                if(nums[i]<=j){
             take= 1+ dp[i-1][j-nums[i]];
                }
                int nottake= dp[i-1][j];
                dp[i][j]= take+nottake;
            }
        }
        return dp[n-1][sum];
    }
}