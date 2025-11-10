class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int count=map.getOrDefault(nums[i],0)+1;
           map.put(nums[i], count); 
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>nums.length/2){
                ans= entry.getKey();
            }
        }
        return ans;
    }
}