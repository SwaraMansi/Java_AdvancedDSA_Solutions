class Solution {
    public int change(int target,int[] arr) {
        int n = arr.length;
    int[][] dp= new int[n+1][target+1];
    dp[0][0]=1;
    for(int i=1;i<=n;i++){
        for(int t=0; t<=target; t++){
         dp[i][t]= dp[i-1][t];
         if(arr[i-1]<=t){
            dp[i][t]= (dp[i][t] + dp[i][t-arr[i-1]]);
         }
        }
    }
    return dp[n][target];
    }
}