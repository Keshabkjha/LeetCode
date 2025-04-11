class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1; // We've already counted 1

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1); // Count nodes between curr and curr+1
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    private long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1L, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }
}
