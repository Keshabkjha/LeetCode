class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int matlength = matrix.length;
        int left = matrix[0][0], right = matrix[matlength-1][matlength-1];
        while(left<right){
            int mid = left +(right-left)/2;
            int count = Countmatrix(matrix,mid);
            if(count < k){
                left = mid+1;

            }
            else{
                right = mid;
            }
        }
        return left;
    }
    private static int Countmatrix(int[][] matrix, int mid){
        int matlength = matrix.length;
        int i = matlength-1,j = 0, count = 0;
        while(i>= 0 && j<matlength){
            if(matrix[i][j]<=mid){
                count+=(i+1);
                j++;
            }
            else{
                i--;
            }
        }
        return count;
    }
}