class Solution {
    public int minDistance(String word1, String word2) {
        int m= word1.length();
        int n= word2.length();
        int[][] dp= new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(m-1,n-1,word1,word2,dp);
    }
    public int helper(int i,int j,String p,String s, int[][] dp){
       if (i < 0) return j + 1; 
        if (j < 0) return i + 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(p.charAt(i)==s.charAt(j)){
            dp[i][j]= 0+helper(i-1,j-1,p,s,dp);
        }
        else{
            dp[i][j]= 1+ Math.min(helper(i-1,j,p,s,dp) , Math.min(helper(i,j-1,p,s,dp), helper(i-1,j-1,p,s,dp)));
        }
        return dp[i][j];
    }
}