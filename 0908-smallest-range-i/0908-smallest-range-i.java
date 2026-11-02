class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        
        // Find the min and max elements in the array
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Calculate the difference after applying the optimal +k and -k
        int diff = (max - k) - (min + k);
        
        // If diff is negative, it means they can overlap completely (score 0)
        return Math.max(0, diff);
    }
}