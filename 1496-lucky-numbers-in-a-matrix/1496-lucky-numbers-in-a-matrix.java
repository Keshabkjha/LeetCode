class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        //finding given matrix dimension
        int r = matrix.length;
        int c = matrix[0].length;

        int posj = 0; 
         // as loop keeps on moving but we need to keep track of position 
         //where we found max value so it stores pos of row
        
        
        for(int i = 0 ; i<c;i++){ //we will travel col
            int max = 0;   //after each col travel reset parameters
            int min = Integer.MAX_VALUE;
            
            for(int j = 0 ; j<r;j++){  //traveling row ie elements of that col
                if(matrix[j][i]>max){  // storing max value of that col
                    max = matrix[j][i];
                    posj = j;
                }
            }
            //now we have found maximum number of that column
            //now travelling the row
            for(int k = 0; k<c;k++){
                if(matrix[posj][k]<=min){  //storing min value of that row
                    min = matrix[posj][k];
                }
            }
            if(max==min){//case of lucky number
            ans.add(max);
            }
        }
        return ans;
    }
}