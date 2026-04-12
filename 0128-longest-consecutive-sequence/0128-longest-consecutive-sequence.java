class Solution {
    public int longestConsecutive(int[] nums) {
      int n= nums.length;
      HashSet<Integer> set= new HashSet<>();
      for(int num:nums){
        set.add(num);
      }
      int maxi=0;
      int count=0;
      for(int num:set){
        if(!set.contains(num-1)){
          
            count=1;
            int current=num;
        while(set.contains(current+1)){
            current++;
            count++;
        }
        maxi= Math.max(maxi,count);
      }
      }
      return maxi;
    }
}
