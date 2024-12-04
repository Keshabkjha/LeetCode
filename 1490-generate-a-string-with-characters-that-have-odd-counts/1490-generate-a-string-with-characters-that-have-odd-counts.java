class Solution {
    public String generateTheString(int n) {
        StringBuilder res=new StringBuilder();
        if(n%2==1) {
            res.append("a".repeat(n));
        }
        else {
            res.append("a".repeat(n-1));
            res.append('b');
        }
        return res.toString();
    }
}