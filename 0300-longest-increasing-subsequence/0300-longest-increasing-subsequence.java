class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);

        }
        return helper(nums,dp,n-1,n);

    }
    public int helper(int nums[],int dp[][], int i , int par){
        if(i<0) return 0;
        if(dp[i][par]!=-1){
            return dp[i][par];
        }
        int notTake = helper(nums,dp,i-1,par);
        int take = 0;
        if(par==nums.length || nums[i]<nums[par]){
            take = 1+ helper(nums,dp,i-1,i);
        }
        dp[i][par] = Math.max(take,notTake);
        return dp[i][par];
    }
}