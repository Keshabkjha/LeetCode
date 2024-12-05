class Solution {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }
        int wL = 0;
        int wR = 0;
        
        for (int i = 0; i < start.length(); i++) {
            char cur = start.charAt(i);
            char goal = target.charAt(i);
            
            if (cur == 'R') {
                if (wL > 0) {
                    return false;
                }
                wR++;
            }
            if (goal == 'L') {
                if (wR > 0) {
                    return false;
                }
                wL++;
            }
            if (goal == 'R') {
                if (wR == 0) {
                    return false;
                }
                wR--;
            }
            if (cur == 'L') {
                if (wL == 0) {
                    return false;
                }
                wL--;
            }
        }
        
        return wL == 0 && wR == 0;
    }
}