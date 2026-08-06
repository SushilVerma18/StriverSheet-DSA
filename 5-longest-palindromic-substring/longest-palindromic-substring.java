class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String LPS = "";

        if(n <=1) return s;

        for(int i = 1; i < n; i++){
            int low = i;
            int high = i;

            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high > n-1) break;
            }

            String palindrome = s.substring(low+1, high);

            if(LPS.length() < palindrome.length()){
                LPS = palindrome;
            }


            //even

            low = i-1;
            high = i;

            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high > n-1) break;
            }

            palindrome = s.substring(low+1, high);

            if(LPS.length() < palindrome.length()){
                LPS = palindrome;
            }

        }

        return LPS;
    }
}