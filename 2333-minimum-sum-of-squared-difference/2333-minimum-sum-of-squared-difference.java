class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        
        // Find absolute differences and track the maximum difference
        int maxDiff = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        // Frequency array to count how many times each difference appears
        long[] count = new long[maxDiff + 1];
        for (int d : diffs) {
            count[d]++;
        }
        
        // Greedily reduce the largest differences first
        for (int d = maxDiff; d > 0 && totalK > 0; d--) {
            if (count[d] == 0) continue;
            
            long take = Math.min(totalK, count[d]);
            count[d] -= take;
            count[d - 1] += take;
            totalK -= take;
        }
        
        // If operations are left over and all differences are 0, return 0
        if (totalK > 0) {
            return 0;
        }
        
        // Calculate the minimum sum of squared differences
        long ans = 0;
        for (int d = 0; d <= maxDiff; d++) {
            if (count[d] > 0) {
                ans += count[d] * (long) d * d;
            }
        }
        
        return ans;
    }
}