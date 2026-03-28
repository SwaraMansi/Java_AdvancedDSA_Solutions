class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
       HashSet<Integer> set= new HashSet<>();
         for(int i=0;i<n;i++){
            set.add(nums[i]);
         }
       int maxi=0;
       for (int num : set){
        if(!set.contains(num-1)){
          int count=1;
               int current = num;

                while (set.contains(current + 1)) {
                    current++;
            count++;
            }
            maxi= Math.max(maxi,count);
        }
       }
       return maxi;
    }
}
