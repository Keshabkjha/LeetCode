class Solution {
    public int waysToSplitArray(int[] nums) {
        long rightSplit = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSplit += nums[i];
        }
        long leftSplit = 0;

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSplit += nums[i];
            rightSplit -= nums[i];
            if (leftSplit >= rightSplit) {
                sum++;
            }
        }
        return sum;
    }
}