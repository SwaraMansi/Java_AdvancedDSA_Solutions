class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n =prices.length;
         dp= new Integer[n][3][2];
        return solve(0,2,1,prices);
    }
    public int solve(int i,int t,int canBuy, int[] prices){
        if(i==prices.length || t==0) return 0;
        if(dp[i][t][canBuy] != null) return dp[i][t][canBuy];
        int profit;
        if(canBuy==1){
            int buy= -prices[i] + solve(i+1,t, 0,prices);
            int skip= solve(i+1,t, 1,prices);
            profit= Math.max(buy,skip);
            }
else{
    int sell= prices[i] + solve(i+1,t-1,1,prices);
    int skip= solve(i+1,t, 0,prices);
     profit= Math.max(sell,skip);
}
return dp[i][t][canBuy]= profit;
    }
}