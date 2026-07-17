class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 1;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        long[] cnt = new long[max + 1];

        // Frequency of each number
        for (int x : nums) {
            cnt[x]++;
        }

        // Count pairs whose gcd is divisible by i
        for (int i = 1; i <= max; i++) {
            long c = 0;
            for (int j = i; j <= max; j += i) {
                c += cnt[j];
            }
            cnt[i] = c * (c - 1) / 2;
        }

        // Inclusion-Exclusion:
        // cnt[i] becomes number of pairs with gcd exactly i
        for (int i = max; i >= 1; i--) {
            for (int j = i + i; j <= max; j += i) {
                cnt[i] -= cnt[j];
            }
        }

        // Prefix sums
        for (int i = 1; i <= max; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = lowerBound(cnt, max, queries[i] + 1);
        }

        return ans;
    }

    private int lowerBound(long[] prefix, int max, long target) {
        int low = 1;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}