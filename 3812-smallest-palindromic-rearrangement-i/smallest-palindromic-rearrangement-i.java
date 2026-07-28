class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            // Character appearing odd number of times
            if (freq[i] % 2 != 0) {
                middle = (char) ('a' + i);
            }

            // Half of the characters go to left side
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString()
                + (middle == 0 ? "" : String.valueOf(middle))
                + right;
    }
}