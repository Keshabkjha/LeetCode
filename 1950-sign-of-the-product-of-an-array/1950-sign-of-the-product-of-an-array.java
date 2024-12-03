class Solution {
    public int arraySign(int[] nums) {
        int count=1;

        for(int num:nums){
            if(num>0) count*=1;
            else if(num<0) count*=-1;
            else count=0;
        }

        return count;
        
    }
}