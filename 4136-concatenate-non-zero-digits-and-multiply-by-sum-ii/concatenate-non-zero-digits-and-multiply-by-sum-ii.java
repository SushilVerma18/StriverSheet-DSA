class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefVal = new long[n + 1];
        long[] digitSum = new long[n + 1];
        int[] cnt = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix arrays
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefVal[i + 1] = prefVal[i];
            digitSum[i + 1] = digitSum[i];
            cnt[i + 1] = cnt[i];

            if (d != 0) {
                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
                digitSum[i + 1] += d;
                cnt[i + 1]++;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int leftCnt = cnt[l];
            int rightCnt = cnt[r + 1];
            int k = rightCnt - leftCnt;

            long sum = digitSum[r + 1] - digitSum[l];

            long x = (prefVal[r + 1]
                    - (prefVal[l] * pow10[k]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}