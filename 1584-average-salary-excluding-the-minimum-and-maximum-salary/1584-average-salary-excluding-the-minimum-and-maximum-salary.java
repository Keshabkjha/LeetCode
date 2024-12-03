class Solution {
    public double average(int[] salary) 
    {
        int size=salary.length;  //total size of salary array
        Arrays.sort(salary);  // Sort the array
        double sum=0;
        for(int i=1;i<size-1;i++) //loop to excluse minimum and maximum
        {
            sum+=salary[i];  //finding total salary without min and max 
        }
        return sum/(size-2);  // size is (size-2) after exclusing minimum and maximum
    }
}