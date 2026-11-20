class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        // Initialize an ArrayList to store the result subsequence
        List<Integer> minSubSequence = new ArrayList<>();
        
        // Sort the array in non-decreasing order
        Arrays.sort(nums);
        
        // Calculate the total sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Initialize current sum of the subsequence
        int current_sum = 0;
        
        // Iterate through sorted array to construct the subsequence
        for (int j = nums.length - 1; j >= 0; j--) {
            sum -= nums[j];  // Subtract the current number from total sum
            current_sum += nums[j];  // Add the current number to current sum
            minSubSequence.add(nums[j]);  // Add current number to subsequence
            
            // Check if current sum of subsequence > sum of remaining elements
            if (current_sum > sum) {
                return minSubSequence;  // Return the subsequence
            }
        }
        
        return minSubSequence;  // Return the subsequence if no conditions met
    }
}