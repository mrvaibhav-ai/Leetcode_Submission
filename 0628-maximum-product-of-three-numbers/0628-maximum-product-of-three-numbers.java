import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        // Sort the array to easily access smallest and largest elements
        Arrays.sort(nums);
        
        // Option 1: Product of the three largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // Option 2: Product of the two smallest numbers and the largest number
        int option2 = nums[0] * nums[1] * nums[n - 1];
        
        // Return the maximum of both options
        return Math.max(option1, option2);
    }
}