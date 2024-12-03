class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numFreqMp = new HashMap<>();
        int answer = 0;
        for(var num : nums){
            answer += numFreqMp.getOrDefault(num, 0);
            numFreqMp.put(num, numFreqMp.getOrDefault(num, 0) + 1);
        }
        return answer;
    }
}