class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int oldRow = mat.length;
        int oldCol = mat[0].length;


        //We have to check whether it is possible to construct-
        //-a new array or not.
        //we can check it by comparing the total elements.
        if(oldCol*oldRow != r*c) return mat;

        int [] [] arr = new int[r][c];
        int i = 0;      // row of new array
        int j = 0;      // col of new array
        int k = 0;      // row of old array
        int l = 0;      // col of old array

        //Traverse the new array and put elements from the old array.
        for(i = 0; i < r; i++)
        {
            for(j = 0; j < c; j++)
            {
                arr[i][j] = mat[k][l];

                //We also need to update the indices of the old array.
                //If column length is reached then increment row
                // and reset column to 0;
                l++;
                if(l == oldCol)
                {
                    k++;
                    l = 0;
                }

            }
        }
        //Finally, return the new array;
        return arr;
        
    }
}