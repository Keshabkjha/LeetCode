class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str1 = new Stack<>();
        Stack<Character> str2 = new Stack<>();
        
        for (char c : s.toCharArray() )
        {
            if (c == '#'){ 
                if (!str1.isEmpty()) str1.pop();
            }else str1.push(c);
        }
        for (char c : t.toCharArray() )
        {
            if (c == '#'){
                if (!str2.isEmpty()) str2.pop();
            }else str2.push(c);
        }

        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        
        while(!str1.isEmpty())
            res1.append(str1.pop());
        
        while(!str2.isEmpty())
            res2.append(str2.pop());
        
        return res1.toString().equals(res2.toString());
    }
}