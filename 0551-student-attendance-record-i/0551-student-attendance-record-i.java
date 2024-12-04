class Solution {
    public boolean checkRecord(String s) {
        int count=0;
        int count2=0;
        boolean flag1=false;
        boolean flag2=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                count++;
                count2=0;
                flag1=false;
                flag2=true;
            }
            if(s.charAt(i)=='L' && (flag1==false || flag2==false)){
                count2++;
                flag1=true;
                flag2=false;
            }
            else
                count2=0;
            if(count==2 || count2==3)
                return false;
        }
        return true;
    }
}