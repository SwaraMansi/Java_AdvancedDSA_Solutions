class Solution {
    public boolean rotateString(String s, String goal) {
        String result= s+s;
        if(s.length()!=goal.length()) return false;
if(result.contains(goal)){
    return true;
}
return false;
    }
}