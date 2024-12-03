class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int i = 0 ; 
        List<Integer> ans = new ArrayList();

        if (n < 2) return new ArrayList<Integer>(1);

        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                if (correctIndex < n) {
                    swap(nums, i, correctIndex);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}