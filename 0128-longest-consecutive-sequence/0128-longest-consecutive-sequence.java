class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
       HashSet<Integer> set= new HashSet<>();
         for(int i=0;i<n;i++){
            set.add(nums[i]);
         }
       int maxi=0;
       for(int i=0;i<n;i++){
        if(!set.contains(nums[i]-1)){
          int count=1;
               int current = nums[i];

                while (set.contains(current + 1)) {
                    current++;
            count++;}
            maxi= Math.max(maxi,count);
        }
       }
       return maxi;
    }
}
