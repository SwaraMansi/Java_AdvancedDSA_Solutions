class Solution {
    public int majorityElement(int[] nums) {
        int n =nums.length;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i =0; i< nums.length;i++){
       int count = map.getOrDefault(nums[i],0)+1;
        map.put(nums[i], count);
       if(count > n/2){
        return nums[i];
       }
       }
       return -1;
       }
}