class Solution {
    public char findTheDifference(String s, String t) {
       List<Character> ch = new ArrayList<>();
       for(char c : t.toCharArray()){
           ch.add(c);
       }
       for(int i=0;i<s.length();i++){
           ch.remove((Character)s.charAt(i));
       }
        if(ch.size()==1){
            return ch.get(0);
        }else{
            return ' ';
        }
    }
}