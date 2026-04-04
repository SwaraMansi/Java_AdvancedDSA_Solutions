class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> result= new ArrayList<>();
        backtrack( n,1, new ArrayList<>(), k,result);
        return result;
    }
    private void backtrack(int remaining, int start, List<Integer> combination, int k,List<List<Integer>> result){
        if(remaining==0){
            if(combination.size()==k)
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<=9;i++){
            if (i > remaining) break;
            combination.add(i);
            backtrack(remaining-i,i+1,combination,k,result);
            combination.remove(combination.size()-1);
        }
    }
}