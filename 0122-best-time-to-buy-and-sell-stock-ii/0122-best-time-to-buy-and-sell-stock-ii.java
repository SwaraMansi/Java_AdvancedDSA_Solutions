class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n =prices.length;
        dp= new Integer[n][2];
        return solve(0,1,prices);
    }
    public int solve(int i,int canBuy, int[] prices){
        if(i==prices.length) return 0;
        if(dp[i][canBuy] != null) return dp[i][canBuy];
        int profit;
        if(canBuy==1){
            int buy= -prices[i] + solve(i+1, 0,prices);
            int skip= solve(i+1, 1,prices);
            profit= Math.max(buy,skip);
            }
else{
    int sell= prices[i] + solve(i+1,1,prices);
    int skip= solve(i+1, 0,prices);
     profit= Math.max(sell,skip);
}
return dp[i][canBuy]= profit;
    }
}