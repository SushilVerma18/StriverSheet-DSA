class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int j = 0;j<n;j++){
            if (freq[s.charAt(j) - 'a'] == 1) {
                return j;
            }
        }
        return -1; 
    }
}