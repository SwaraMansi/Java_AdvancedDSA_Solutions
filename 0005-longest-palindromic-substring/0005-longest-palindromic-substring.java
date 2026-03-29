class Solution {
    public String longestPalindrome(String s) {
       String longest="";
       int n= s.length();
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            String sub= s.substring(i,j+1);
            if(isPalindrome(sub) && sub.length()> longest.length()){
                longest=sub;
            }
        }
       }
       return longest;
    }    private static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
    }