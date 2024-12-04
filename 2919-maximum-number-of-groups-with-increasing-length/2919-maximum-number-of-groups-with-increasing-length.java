class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long k = 0;
        long total = 0L;
        for(int i = 0; i < usageLimits.size(); i++) {
            total += usageLimits.get(i);
            if((k + 1) * (k + 2) / 2 <= total) {
                k++;
            }
        }
        return (int)k;
    }
}