class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans = 0, l = nums.length, start = 0, i = 0;
        Arrays.sort(nums);
        k *= 2;
        for(; i < l - 1; i++) {
            ans = Math.max(ans, i - start + 1);
            while(nums[i + 1] > nums[start] + k) {
                start++;
            }
        }
        return Math.max(ans, i - start + 1);
    }
}