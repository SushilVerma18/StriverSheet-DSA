import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        Set<Integer> pairXor = new HashSet<>();

        // Store XOR of every pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        BitSet ans = new BitSet();

        // Pair XOR ^ third element
        for (int xor : pairXor) {
            for (int num : nums) {
                ans.set(xor ^ num);
            }
        }

        // Triplets like (i,i,i) => nums[i]
        for (int num : nums) {
            ans.set(num);
        }

        return ans.cardinality();
    }
}