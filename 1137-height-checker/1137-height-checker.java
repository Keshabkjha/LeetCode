class Solution {
    public int heightChecker(int[] heights) {
        int[] ans = new int[heights.length];
        for(int j=0;j<ans.length;j++){
            ans[j]=heights[j];
        }
        int count=0;
        Arrays.sort(heights);
        for(int i=0;i<ans.length;i++){
            if(ans[i]!=heights[i]) count++;
        }
        return count;
        
    }
}