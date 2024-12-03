class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int ascAr[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ascAr);
        int descAr[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(descAr);
        Collections.reverse(Arrays.asList(descAr));
        int ascD=ascAr[0] - ascAr[1];
        int descD=descAr[0] - descAr[1];
        int f=1; // true
        for(int i=1;i<arr.length -1;i++){
            if(ascAr[i] - ascAr[i+1] != ascD){
                f=0; // false
                break;
            }
            if(descAr[i] - descAr[i+1] != descD){
                f=0; // false
                break;
            }
        }
        return f==1? true : false ;
    }
}