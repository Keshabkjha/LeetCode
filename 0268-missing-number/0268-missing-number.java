class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
    //     Arrays.sort(nums);
     
    //     for(int i=0;i<n;i++ )
    //     {
    //         if(nums[i]==i+1)
    //         {
    //              return i;
                 
    //         }
    //     }
    //    return n;     
      int sum=0;
      int sum1=(n)*(n+1)/2;
      for(int i=0;i<n;i++)
      {
          sum=nums[i]+sum;

      }
      if(sum==sum1)
      {
          return 0;
      }else{
          return (sum1-sum);
      }
    }
}