class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        char ch = ' ';

        while(low <= high){
            int mid = low +(high - low)/2;

            if(letters[mid] > target){
                ch = letters[mid];
                high = mid - 1;
            }

            if(letters[mid] <= target){
                low = mid + 1;
            }
        }
        if(ch == ' ') return letters[0];
        return ch;
    }
}