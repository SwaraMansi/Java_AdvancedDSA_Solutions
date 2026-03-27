class Solution {
    public int[] twoSum(int[] arr, int target) {
      int n = arr.length;
      int res=0;
       HashMap<Integer, Integer> map= new HashMap<>();
       
       for(int i=0;i<n;i++){
        res= target- arr[i];
        if(map.containsKey(res)){
            return new int[]{i, map.get(res)};
        }
        map.put(arr[i], i);
       }
       return new int[]{-1,-1};
    }
}