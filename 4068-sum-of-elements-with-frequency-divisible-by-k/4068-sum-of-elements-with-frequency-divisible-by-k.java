class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
      Map<Integer,Integer> map= new HashMap<>();
      int sum=0;
      for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
      }   
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

        if(count%k==0){
            sum+=num*count;
        }
      }
      return sum;
    }
}