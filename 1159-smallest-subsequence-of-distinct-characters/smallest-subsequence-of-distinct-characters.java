import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {

        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> last = new HashMap<>();

        
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }

        HashSet<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (visited.contains(ch)) {
                continue;
            }

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > ch &&
                   last.get(sb.charAt(sb.length() - 1)) > i) {

                visited.remove(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            visited.add(ch);
        }

        return sb.toString();
    }
}