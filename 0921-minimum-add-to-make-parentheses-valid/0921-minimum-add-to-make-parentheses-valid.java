class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // Unmatched '(' count
        int moves = 0;  // Needed '(' for unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--; // Match current ')' with a previous '('
                } else {
                    moves++; // Unmatched ')' requires an inserted '('
                }
            }
        }

        // Total additions needed = unmatched ')' + unmatched '('
        return moves + open;
    }
}