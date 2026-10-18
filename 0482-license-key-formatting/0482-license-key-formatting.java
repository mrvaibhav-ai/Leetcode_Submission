class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // traverse from end
        for (int i = s.length() - 1, count = 0; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '-') continue;

            if (count == k) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(c));
            count++;
        }

        return sb.reverse().toString();
    }
}