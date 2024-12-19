class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxInChunk = 0;
        for (int i = 0; i < arr.length; i++) {
            maxInChunk = Math.max(maxInChunk, arr[i]);
            if (maxInChunk == i) {
                chunks++;
            }
        }
        return chunks;
    }
}