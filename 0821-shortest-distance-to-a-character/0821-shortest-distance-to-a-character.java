class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        
        // --- First Pass: Left to Right ---
        // Track the index of the last seen character 'c'. 
        // Initialize with a large negative number to handle characters before the first 'c'.
        int prev = -n; 
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }
        
        // --- Second Pass: Right to Left ---
        // Track the index of the last seen character 'c' from the right.
        // Initialize with a large positive number to handle characters after the last 'c'.
        prev = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }
        
        return result;
    }
}