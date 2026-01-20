class Solution {
    public String reverseWords(String s) {
        StringBuilder sb= new StringBuilder();
     String[] words = s.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]+ " ");  
        }
      String ans= sb.toString().trim();
      return ans;
    }
}