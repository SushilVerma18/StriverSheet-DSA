class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        // Store positions of all 1s
        int[] pos = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pos[count++] = i;
            }
        }

        // Not enough 1s
        if (count < k) {
            return "";
        }

        String ans = "";

        // Check every group of k consecutive 1s
        for (int i = 0; i <= count - k; i++) {
            int start = pos[i];
            int end = pos[i + k - 1];

            String curr = s.substring(start, end + 1);

            if (ans.isEmpty()
                    || curr.length() < ans.length()
                    || (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                ans = curr;
            }
        }

        return ans;
    }
}