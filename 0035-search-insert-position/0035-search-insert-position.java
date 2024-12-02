class Solution {
    public int searchInsert(int[] nums, int target) {
        ArrayList<Integer>atr=new ArrayList<>();
        for(int a:nums){
            atr.add(a);
        }
        atr.add(target);
        Collections.sort(atr);
        int k=atr.indexOf(target);
        return k;
        
    }
}