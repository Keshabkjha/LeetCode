class Solution {
    public int findLengthOfLCIS(int[] nums) 
    {
        int maxCount = 1;
        int currentCount = 1;
        int i = 0 ;
        int j = 1;
        while(j<nums.length)
        {
            if(nums[j]>nums[i])
            {
                currentCount++;
                i++;
                j++;
            }
            else
            {
                i = j;
                j++;
                currentCount = 1;
            }
            if(maxCount<currentCount)
            {
                maxCount = currentCount;
            }
        }  
        return maxCount;  
    }
}