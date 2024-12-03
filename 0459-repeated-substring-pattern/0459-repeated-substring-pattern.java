class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // concatenate the strings
        // remove the first and last character check if the string is still present
        String concat = s + s;
        String res = concat.substring(1, concat.length() -1);
        return res.contains(s);
        
    }

    
}