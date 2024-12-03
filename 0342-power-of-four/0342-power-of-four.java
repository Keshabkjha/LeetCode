class Solution {
    public boolean isPowerOfFour(int n) {
        return  n  > 0 && Math.floor(Math.log(n)/Math.log(4)) == Math.ceil(Math.log(n)/Math.log(4));
    }
}