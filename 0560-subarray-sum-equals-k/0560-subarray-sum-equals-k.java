class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int n= nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int num:nums){
             sum+=num;
             int remove= sum-k;
             if(map.containsKey(remove)){
                count+= map.get(remove);
             }
             map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}