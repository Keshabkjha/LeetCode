class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans =0;
        for(Integer i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        for(Integer i : map.keySet()){
            if(map.get(i) > (nums.length)/2)
                return i;
        }

        return -1;
        
    }
}