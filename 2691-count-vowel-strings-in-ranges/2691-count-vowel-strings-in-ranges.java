class Solution {

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;
        int[] cumSum = new int[n];
        int[] ans = new int[q];

        // Calculate cumulative sums in a single loop
        int val = 0;
        for (int i = 0; i < n; i++) {
            int l = words[i].length();
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(l - 1))) {
                val++;
            }
            cumSum[i] = val;
        }

        // Process queries
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }

        return ans;
    }
}
