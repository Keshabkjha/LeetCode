class Solution {
    public long minCost(int[] nums, int[] cost) {
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long answer = Long.MAX_VALUE;

        while (min < max) {
            long mid = (max + min) / 2;

            long midCost = getCostSum(mid, nums, cost);
            long nextMidCost = getCostSum(mid + 1, nums, cost);

            answer = Math.min(midCost, nextMidCost);
            
            if (midCost > nextMidCost) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return answer == Long.MAX_VALUE ? 0 : answer;
    }

    private long getCostSum(long required, int[] nums, int[] cost) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long requiredIncOrDec = Math.abs(required - num);
            
            sum += ((long) (cost[i] * requiredIncOrDec));
        }

        return sum;
    }
}