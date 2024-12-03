class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        for (int[] row : accounts) {
            int wealth = 0;
            for (int money : row) wealth += money;
            maxWealth = Math.max(wealth, maxWealth);
        }
        
        return maxWealth;
    }
}

// TC: O(m * n)