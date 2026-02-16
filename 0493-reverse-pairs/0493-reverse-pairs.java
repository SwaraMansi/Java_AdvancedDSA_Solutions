class Solution {
    public int reversePairs(int[] nums) {
     return mergesort(nums,0,nums.length-1);   
    }
    private int mergesort(int[] nums,int low,int high){
        if(low>=high) return 0;
     int mid= (low+high)/2;
     int count= mergesort(nums,low,mid) + mergesort(nums,mid+1,high);
     int j=mid+1;
     for(int i=low;i<=mid;i++){
        while(j<=high && (long) nums[i] >2L * nums[j]){
            j++;
        }
        count+=j-(mid+1);
     }
     merge(nums,low,mid,high);
     return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) temp.add(nums[left++]);
        while (right <= high) temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}