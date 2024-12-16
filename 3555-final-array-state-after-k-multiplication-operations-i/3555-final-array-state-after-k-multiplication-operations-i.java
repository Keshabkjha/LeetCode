class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int min=Integer.MAX_VALUE;
        int ind=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    ind=j;
                }
            }
            nums[ind]*=multiplier;
            min=Integer.MAX_VALUE;
        }
        return nums;
    }
}