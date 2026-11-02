import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
            // Step 1: Sort the array to easily find the median
                    Arrays.sort(nums);
                            
                                    // Step 2: Choose the median element as the target
                                            int median = nums[nums.length / 2];
                                                    
                                                            int moves = 0;
                                                                    // Step 3: Calculate the total moves required to reach the median
                                                                            for (int num : nums) {
                                                                                        moves += Math.abs(num - median);
                                                                                                }
                                                                                                        
                                                                                                                return moves;
                                                                                                                    }
                                                                                                                    }
                                                                                                                    