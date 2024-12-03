class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0 , y = 0 ;
        // Initial Coordinate of  Robot(0,0)
        
        char currDirection = 'N' ;
        // Initial Direction of our Robot         
        for(int i = 0 ; i < instructions.length() ; i++){
            
            //If the current instruction is 'G' that means we need to check the current Direction of the Robot
            if(instructions.charAt(i) == 'G'){
                y += currDirection == 'N'? 1 : 0 ;  // If Robot goes North that means it gains a coordinate in y-axis 
                y += currDirection == 'S'?-1 : 0 ;  // If Robot goes South that means it loses a coordinate in y-axis 
                x += currDirection == 'E'? 1 : 0 ;  // If Robot goes East that means it gains a coordinate in x-axis 
                x += currDirection == 'W'?-1 : 0 ;  // If Robot goes West that means it loses a coordinate in x-axis 
                
            }
            // If current Instruction is not 'G' i.e it is either 'L' or 'R' int that case we have to change the current Direction of the Robot
            else{
                char ch = instructions.charAt(i) ; // ch holds current instruction
                
                /*
                 * If Robot is facing 'North' and the instruction we got is 'L' then the new direction
                 *       will be 'West' 
                 * else if it is 'R' then new Direction
                 *       will be 'East'
                */
                if(currDirection == 'N'){
                    currDirection = ch=='L' ? 'W' : 'E';
                }
                
                /*
                 * If Robot is facing 'West' and the instruction we got is 'L' then the new direction
                 *       will be 'South' 
                 * else if it is 'R' then new Direction
                 *       will be 'North'
                */
                else if(currDirection == 'W'){
                    currDirection = ch=='L' ? 'S' : 'N';
                }
                
                /*
                 * If Robot is facing 'South' and the instruction we got is 'L' then the new direction
                 *       will be 'East' 
                 * else if it is 'R' then new Direction
                 *       will be 'West'
                */
                else if(currDirection == 'S'){
                    currDirection = ch=='L' ? 'E' : 'W';
                }
                
                /*
                 * If Robot is facing 'East' and the instruction we got is 'L' then the new direction
                 *       will be 'North' 
                 * else if it is 'R' then new Direction
                 *       will be 'South'
                */
                else if(currDirection == 'E'){
                    currDirection = ch=='L' ? 'N' : 'S' ;
                }
                
            }
            
        }
        /*Observation*/
        if((x==0 && y==0) || currDirection != 'N' ){
            return true ;
        }
        return false ;
    }
}