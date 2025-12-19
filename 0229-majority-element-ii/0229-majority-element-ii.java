class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj= nums.length/3;
        ArrayList<Integer> res= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>maj){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}