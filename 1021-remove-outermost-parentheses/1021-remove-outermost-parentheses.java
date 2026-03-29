class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder();
        int count=0;
        for(char st : s.toCharArray()){
            if(st=='('){
                if(count>0){
                    sb.append(st);
                }
                count++;
            }else {
                count--;
                if(count>0){
                    sb.append(st);
                }
            }
        }
        return sb.toString();
    }
}