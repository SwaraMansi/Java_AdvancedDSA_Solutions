class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
       List<List<Integer>> result= new ArrayList<>();
        backtrack(candidates, target,0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates,int remaining, int start, List<Integer> combination, List<List<Integer>> result){
        if(remaining==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
           if (i > start && candidates[i] == candidates[i - 1]) continue;   
            if (candidates[i] > remaining) break;
            combination.add(candidates[i]);
            backtrack(candidates,remaining-candidates[i],i+1,combination,result);
            combination.remove(combination.size()-1);
        }     
    }
}