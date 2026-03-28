class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n= nums.length;
       int[] pos= new int[n/2];
       int[] neg= new int[n/2];
       int k=0, p=0;
       for(int i=0;i<n;i++){
        if(nums[i]>0){
            pos[k++]= nums[i];
        }
        else{
            neg[p++]= nums[i];
        }
       }
       int[] res= new int[n];
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