class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = (A[0]==B[0]) ? 1 : 0;
        for(int i=1;i<n;i++){
            ans[i]=ispresent(i,A,B);
        }
        return ans;
    }
    public int ispresent(int k, int[] A, int[] B){
        int count=0;
        for(int i=0;i<=k;i++){
            for(int j=0;j<=k;j++){
                if(A[i]==B[j]){
                    count++;
                }
            }
        }
        return count;
    }
}