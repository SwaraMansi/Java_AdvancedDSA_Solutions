class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> answer = new ArrayList<>();
        backtrack(answer, new StringBuilder(), 0, 0, n);
        
        return answer;
        
    }
    
    
    public void backtrack(List<String> answer, StringBuilder currString, int leftCount, int rightCount, int n) {
        if (currString.length() == 2*n){
            answer.add(currString.toString());
            return;
        }
        
        if (leftCount < n){
            currString.append("(");
            backtrack(answer, currString, leftCount + 1, rightCount, n);
            currString.deleteCharAt(currString.length() -1);
        }
        
        if(leftCount > rightCount){
            currString.append(")");
            backtrack(answer, currString, leftCount, rightCount + 1, n);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}