class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // declare max to store max candies
        int max = 0;
        // declare result array
        List<Boolean> result = new ArrayList<>();
        // iterate over each candy and find max, set it to max
        for(int candy: candies) max = candy > max ? candy : max;
        // iterate over each candy:
        for(int i = 0; i < candies.length; i++) {
            // check if current candy + extra candies are equals or more than max:
            if(candies[i] + extraCandies >= max) {
                // if true push true to result
                result.add(true);
            } else {
                // if false push false to result
                result.add(false);
            }
        }
        // return result
        return result;
    }
}