class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos= new int[nums.length/2];
      int[] neg= new int[nums.length/2];
int[] res= new int[nums.length];
      int j=0, k=0;
      for(int i =0;i<nums.length;i++){
        if(nums[i]>0){
          pos[j]= nums[i];
          j++;
        }else{
          neg[k]= nums[i];
          k++;
        }
        }
       int idx = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            res[idx] = pos[i];
            idx++;  
            res[idx] = neg[i];
            idx++;  
        }
        
        return res;
   }
}