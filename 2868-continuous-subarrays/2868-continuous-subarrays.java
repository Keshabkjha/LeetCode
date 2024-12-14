class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;

        while (j < n) {
            // Increment the count of nums[j]
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            // Calculate min and max
            int minElem = map.firstKey();
            int maxElem = map.lastKey();
            int diff = maxElem - minElem;

            // If difference > 2, adjust the window
            while (diff > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
                // Update min and max
                minElem = map.firstKey();
                maxElem = map.lastKey();
                diff = maxElem - minElem;
            }

            // Count subarrays in the current window
            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}