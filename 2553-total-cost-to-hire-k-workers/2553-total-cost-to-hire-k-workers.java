class Solution {
    public long totalCost(int[] costs, int k, int cand) {
        long res = 0;
        //[0] is value, [1] is index
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        int[] isLowerHalf = new int[costs.length];
        int l = cand - 1;
        int r = costs.length - cand;
        for(int i = 0; i < cand; i++){
            q.add(new int[]{costs[i], i});
            isLowerHalf[i] = 1;
        }
        for(int i = costs.length - 1; i >= 0 && q.size() < Math.min(2*cand, costs.length); i--){
            q.add(new int[]{costs[i], i});
            isLowerHalf[i] = -1;
        }
        for(int i = 0; i < k; i++){
            int[] min = q.poll();
            res += min[0];
            if(isLowerHalf[min[1]] == 1){
                if(l + 1 < r){
                    q.add(new int[]{costs[l+1], l+1});
                    isLowerHalf[l+1] = 1;
                    l++;
                }
            }
            else{
                if(r - 1 > l){
                    q.add(new int[]{costs[r-1], r-1});
                    isLowerHalf[r-1] = -1;
                    r--;
                }
            }
        }
        return res;
    }
}