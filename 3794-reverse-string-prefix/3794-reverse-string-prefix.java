class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb= new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
        }
        sb.delete(0,k);
        char[] c=s.toCharArray();
        for(int i=0;i<k;i++){
            char ch=s.charAt(i); 
          sb.insert(0, ch);
        }
        return sb.toString();
    }
}