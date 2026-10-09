class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                // We need a pair of ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Current ')' is not enough, insert one ')'
                    ans++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // No '(' to match this '))'
                    ans++;
                }
            }
        }

        // Every remaining '(' needs two ')'
        ans += 2 * open;

        return ans;
    }
}