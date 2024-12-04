class Solution {
    public int numberOfSteps(int n){
        int steps = 0;
        if(n == 0){
            return steps;
        }
        if(n % 2 == 0){
            steps += numberOfSteps(n / 2);
        }
        else{
            steps += numberOfSteps(n - 1);
        }
        steps += 1;
        return steps;
    }
    
}