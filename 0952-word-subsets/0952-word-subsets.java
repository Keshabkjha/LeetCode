class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> list = new ArrayList<>();
        int target[] = new int[26];

        for(String s:words2){
            int fr[] = new int[26];
            for(char c:s.toCharArray()){
                fr[c-'a']++;
                target[c-'a'] = Math.max(target[c-'a'], fr[c-'a']);
            }
        }
        for(String s:words1){
            int child[] = new int[26];
            for(char c:s.toCharArray()){
                child[c-'a']++;
            }
            if(isUniversal(target , child)) list.add(s);
        }
        return list;
    }
    public boolean isUniversal(int parent[] , int child[]){
        for(int i=0;i<26;++i){
            if(child[i] < parent[i]) return false;
        }
        return true;
    }
}