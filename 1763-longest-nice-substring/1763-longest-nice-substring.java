class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        
        // Use a set to keep track of all characters present in the current string
        char[] chars = s.toCharArray();
        boolean[] present = new boolean[128];
        for (char c : chars) {
            present[c] = true;
        }
        
        // Check every character to see if its counterpart exists
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char counterpart = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            
            // If a character lacks its uppercase/lowercase pair, split the string at this character
            if (!present[counterpart]) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                
                // Return the longer nice substring (left takes precedence if lengths are equal)
                return left.length() >= right.length() ? left : right;
            }
        }
        
        // If all characters have their pairs, the whole string is nice
        return s;
    }
}