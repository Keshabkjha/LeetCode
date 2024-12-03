class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for(int i = 1; i<n;i++){
            if(i<2) continue;
            else cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[n-1],cost[n-2]);
    }
}