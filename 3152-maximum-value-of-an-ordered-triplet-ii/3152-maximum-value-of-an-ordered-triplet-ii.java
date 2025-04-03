class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];

        max_left[0] = 0;
        max_right[n-1] = 0;

        for(int i=1;i<n;i++)
            max_left[i] = Math.max(max_left[i-1],nums[i-1]);
        
        for(int i=n-2;i>=0;i--)
            max_right[i] = Math.max(max_right[i+1],nums[i+1]);
        
        long res = 0;

        for(int i=0;i<n;i++)
            res = Math.max(res,(long)(max_left[i] - nums[i])*max_right[i]);
        
        return res;
    }
}