class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;
                high++;
            }

            // Even the minimum balance cannot be negative
            if (high < 0) {
                return false;
            }

            // Balance cannot actually be negative
            low = Math.max(low, 0);
        }

        return low == 0;
    }
}