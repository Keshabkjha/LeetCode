class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        ways(nums, 0, 0, target);
        return count;
    }

    private void ways(int []nums, int index, int sum, int target)
    {
        if(index==nums.length)
        {
            if(sum==target)
            {
                count++;
            }
        }
        else
        {
            ways(nums, index+1, sum+nums[index], target);
            ways(nums, index+1, sum-nums[index], target);
        }
    }
}