class Solution {
    public String reformat(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                sb.append(ch);
            }
            else
            {
                sb1.append(ch);
            }
        }
        int diff = (int)Math.abs(sb.length() - sb1.length());
        if(!(diff == 1 || diff == 0))
        {
            return "";
        }
        if(diff == 0){
        for(int i = 0 ; i < sb.length() ; i++)
        {
            ans.append(sb.charAt(i));
            ans.append(sb1.charAt(i));
        }}
        else
        {
            if(sb.length() > sb1.length())
            {
                for(int i = 0 ; i < sb.length() ; i++)
                {
                    ans.append(sb.charAt(i));
                    if(i < sb1.length())
                    ans.append(sb1.charAt(i));
                }
            }
            else
            {
                for(int i = 0 ; i < sb1.length() ; i++)
                {
                    ans.append(sb1.charAt(i));
                    if(i < sb.length())
                    ans.append(sb.charAt(i));
                    
                }
            }
        }
        return ans.toString();
    }
}