class Solution {
    public int minDistance(String word1, String word2) {
        return lcs(word1, word2);
    }
    private int lcs(String s, String rev){
        int n= s.length();
        int m= rev.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
           dp[i][j]=1+ dp[i-1][j-1];
                }
                else{
                  dp[i][j]= Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        int ans= dp[n][m];   
        return n-ans + m-ans;    
    }
}