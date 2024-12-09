class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]%2 == nums[i-1]%2)
                prefix[i] += (prefix[i-1]+1);
            else
                prefix[i] += (prefix[i-1]);
        }
        int q = queries.length;
        boolean[] ans = new boolean[q];
        int i=0;
        for(int[] qq: queries) {
            ans[i++] = prefix[qq[1]]-prefix[qq[0]] == 0;
        } 
        return ans;
    }
}