class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n<k) return false;
        int []arr = new int[26];
        for(int i = 0; i < n;i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        int count = 0;
        for(var val : arr){
            if (val % 2 != 0) count++;
        }
        return count <= k;
    }
}